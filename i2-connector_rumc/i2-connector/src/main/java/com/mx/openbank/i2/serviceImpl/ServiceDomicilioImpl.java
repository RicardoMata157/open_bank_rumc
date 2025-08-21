package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mx.openbank.i2.entity.Domicilio;
import com.mx.openbank.i2.repository.RepositoryDomicilio;
import com.mx.openbank.i2.service.ServiceDomicilio;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;

@Service
public class ServiceDomicilioImpl implements ServiceDomicilio {

	@Autowired
	private RepositoryDomicilio repositoryDomicilio;

	private UtilConnector util;

	private ContructorEntidades contructorEntidades;
	
	private static final Logger Logger = LogManager.getLogger(ServiceDomicilioImpl.class);

	@Override
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();

		util = new UtilConnector();
		contructorEntidades = new ContructorEntidades();
		String cp = null;
		String ciudad = null;

		for (HashMap<String, String> map : valor) {
			String id = map.get("id");
			String val = map.get("value");
			if ("cp".equalsIgnoreCase(id)) {
				cp = val;
			} else if ("ciudad".equalsIgnoreCase(id)) {
				ciudad = val;

			}
			
		}
		System.out.print(cp);

		
		if (cp != null && ciudad != null) {
			List<Domicilio> domicilios = repositoryDomicilio.consultaDomicio(cp, ciudad);
			Logger.info("Resultado búsqueda: " + domicilios);
			for (Domicilio domicilio : domicilios) {
				listaEntidades.add(contructorEntidades.mapeoEntidadDomicilio(domicilio));
			}
		}

		Map<String, Object> response = util.generateResponse(listaEntidades);
		System.out.print(cp);
		return response;
		
	}

	@Override
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {
		// TODO Auto-generated method stub
		return null;
	}

}
