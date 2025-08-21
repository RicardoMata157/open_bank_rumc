package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.entity.Comercio;
import com.mx.openbank.i2.repository.RepositoryComercio;
import com.mx.openbank.i2.service.ServiceComercio;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;


@Service
public class ServiceComercioImpl implements ServiceComercio {
	@Autowired
	private RepositoryComercio repositoryComercio;

	private static final Logger Logger = LogManager.getLogger(ServiceComercioImpl.class);

	private UtilConnector util;

	private ContructorEntidades contructorEntidades;

	@Override
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();
		Logger.info(valor);
		util = new UtilConnector();
		contructorEntidades = new ContructorEntidades();
		String nombrecomercio = null;

		for (HashMap<String, String> map : valor) {
			String id = map.get("id");
			String val = map.get("value");
			if ("nombrecomercio".equalsIgnoreCase(id)) {
				nombrecomercio = val;
			}
		}
		
		if (nombrecomercio != null ) {
			List<Comercio> comercios = repositoryComercio.consultaComercio(nombrecomercio);
			Logger.info("Resultado búsqueda: " + comercios);
			for (Comercio comercio : comercios) {
				listaEntidades.add(contructorEntidades.mapeoEntidadComercio(comercio));
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
