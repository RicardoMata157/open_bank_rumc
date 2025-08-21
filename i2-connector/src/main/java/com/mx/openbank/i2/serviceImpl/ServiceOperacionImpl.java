package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.entity.Operacion;
import com.mx.openbank.i2.repository.RepositoryOperacion;
import com.mx.openbank.i2.service.ServiceOperacion;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;

@Service
public class ServiceOperacionImpl implements ServiceOperacion {

    @Autowired
    private RepositoryOperacion repositoryOperacion;

    private UtilConnector util;
    private ContructorEntidades contructorEntidades;

    private static final Logger Logger = LogManager.getLogger(ServiceOperacionImpl.class);

    @Override
    public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
        List<Map<String, Object>> listaEntidades = new ArrayList<>();
        Logger.info("Parametros recibidos: " + valor);

        util = new UtilConnector();
        contructorEntidades = new ContructorEntidades();

        String IDtransaccion = null;
        String Codigosoperacionentrada = null;
        String Codigosoperacionsalida = null;
        String LatitudLongitud = null;


        for (HashMap<String, String> map : valor) {
            String id = map.get("id");
            String val = map.get("value");

            if ("IDtransaccion".equalsIgnoreCase(id)) {
            	IDtransaccion = val;
            } else if ("Codigosoperacionentrada".equalsIgnoreCase(id)) {
            	Codigosoperacionentrada = val;
            } else if ("Codigosoperacionsalida".equalsIgnoreCase(id)) {
            	Codigosoperacionsalida = val;
            } else if ("LatitudLongitud".equalsIgnoreCase(id)) {
            	LatitudLongitud = val;
            }
        }


        List<Operacion> operaciones = repositoryOperacion.buscarOperaciones(IDtransaccion, Codigosoperacionentrada, Codigosoperacionsalida, LatitudLongitud);
        Logger.info("Resultado búsqueda: " + operaciones);

        for (Operacion op : operaciones) {
            listaEntidades.add(contructorEntidades.mapeoEntidadOperacion(op));
        }

        Map<String, Object> response = util.generateResponse(listaEntidades);
        return response;
    }

    @Override
    public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {

        return null;
    }
}
