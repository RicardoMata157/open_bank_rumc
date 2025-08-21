package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mx.openbank.i2.entity.CuentaExterna;
import com.mx.openbank.i2.repository.RepositoryCuentaExterna;
import com.mx.openbank.i2.service.ServiceCuentaExterna;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;

@Service
public class ServiceCuentaExternaImpl implements ServiceCuentaExterna {

	@Autowired
	private RepositoryCuentaExterna repositoryCuentaExterna;
	
	private UtilConnector util;
	
	private ContructorEntidades contructorEntidades;

	private static final Logger Logger = LogManager.getLogger(ServiceCuentaExternaImpl.class);

	@Override
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();
		Logger.info(valor);
		util = new UtilConnector();
		contructorEntidades = new ContructorEntidades();
		String numerocuentaentrada = null;
		String numerocuentasalida = null;
		String nombrecompleto = null;
		
		for (HashMap<String, String> map : valor) {
			String id = map.get("id");
			String val = map.get("value");
			if ("numerocuentaentrada".equalsIgnoreCase(id)) {
				numerocuentaentrada = val;
			} else if ("numerocuentasalida".equalsIgnoreCase(id)) {
				numerocuentasalida = val;
			}else if ("nombrecompleto".equalsIgnoreCase(id)) {
				nombrecompleto = val;
			}
		}

		if (numerocuentaentrada != null && numerocuentasalida != null) {
			List<CuentaExterna> cuentasexternas = repositoryCuentaExterna.getRegresaPerona(numerocuentaentrada, numerocuentasalida);
			Logger.info("Resultado búsqueda: " + cuentasexternas);
			for (CuentaExterna cuentaexterna : cuentasexternas) {
				listaEntidades.add(contructorEntidades.mapeoEntidadCuentaExterna(cuentaexterna));
			}
		}
		
		
		if (numerocuentaentrada != null && numerocuentasalida == null  && nombrecompleto != null) {
			List<CuentaExterna>  cuentasexternas = repositoryCuentaExterna.getRegresaPeronaId(nombrecompleto);
			Logger.info("Resultado búsqueda: " + cuentasexternas);
			for (CuentaExterna cuentaexterna : cuentasexternas) {
				listaEntidades.add(contructorEntidades.mapeoEntidadCuentaExterna(cuentaexterna));
			}
			
		}
		
		
		Map<String, Object> response = util.generateResponse(listaEntidades);

		return response;
	}

	@Override
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {
		// TODO Auto-generated method stub
		return null;
	}

}
