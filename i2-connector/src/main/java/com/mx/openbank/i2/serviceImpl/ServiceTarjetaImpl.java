package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.entity.Tarjeta;
import com.mx.openbank.i2.repository.RepositoryTarjeta;
import com.mx.openbank.i2.service.ServiceTarjeta;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;


@Service
public class ServiceTarjetaImpl implements ServiceTarjeta {
	@Autowired
	private RepositoryTarjeta repositoryTarjeta;

	private static final Logger Logger = LogManager.getLogger(ServiceTarjetaImpl.class);

	private UtilConnector util;

	private ContructorEntidades contructorEntidades;

	@Override
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();
		Logger.info(valor);
		util = new UtilConnector();
		contructorEntidades = new ContructorEntidades();
		String numerotarjeta = null;

		for (HashMap<String, String> map : valor) {
			String id = map.get("id");
			String val = map.get("value");
			if ("numerotarjeta".equalsIgnoreCase(id)) {
				numerotarjeta = val;
			}
		}
		
		if (numerotarjeta != null ) {
			List<Tarjeta> tarjetas = repositoryTarjeta.consultaTarjeta(numerotarjeta);
			Logger.info("Resultado búsqueda: " + tarjetas);
			for (Tarjeta tarjeta : tarjetas) {
				listaEntidades.add(contructorEntidades.mapeoEntidadTarjeta(tarjeta));
			}
		}
		

		Map<String, Object> response = util.generateResponse(listaEntidades);


		return response;
	}

	@Override
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {
		return null;
	}
}
