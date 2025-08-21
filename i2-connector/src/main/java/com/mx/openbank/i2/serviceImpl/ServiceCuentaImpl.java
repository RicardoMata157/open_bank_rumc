package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mx.openbank.i2.entity.Cuenta;
import com.mx.openbank.i2.repository.RepositoryCuenta;
import com.mx.openbank.i2.service.ServiceCuenta;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;

@Service
public class ServiceCuentaImpl implements ServiceCuenta {

    @Autowired
    private RepositoryCuenta repositoryCuenta;

    private UtilConnector util;
    private ContructorEntidades contructorEntidades;

    private static final Logger Logger = LogManager.getLogger(ServiceCuentaImpl.class);

    @Override
    public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
        List<Map<String, Object>> listaEntidades = new ArrayList<>();

        util = new UtilConnector();
        contructorEntidades = new ContructorEntidades();
        String numerodecuenta = null;
        String clabeinterbancaria = null;

        // 🔎 Extraer parámetros de búsqueda
        for (HashMap<String, String> map : valor) {
            String id = map.get("id");
            String val = map.get("value");

            if ("numerodecuenta".equalsIgnoreCase(id)) {
                numerodecuenta = val;
            } else if ("clabeinterbancaria".equalsIgnoreCase(id)) {
                clabeinterbancaria = val;
            }
        }

        Logger.info("Parámetros recibidos -> numeroCuenta: " + numerodecuenta + ", clabe: " + clabeinterbancaria);

        // ✅ Llamar siempre al repositorio, aunque uno sea null
        List<Cuenta> cuentas = repositoryCuenta.consultaCuenta(numerodecuenta, clabeinterbancaria);
        Logger.info("Resultado búsqueda: " + cuentas);

        for (Cuenta cuenta : cuentas) {
            listaEntidades.add(contructorEntidades.mapeoEntidadCuenta(cuenta));
        }

        Map<String, Object> response = util.generateResponse(listaEntidades);
        return response;
    }

    @Override
    public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {
        return null;
    }
}
