package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.entity.Persona;
import com.mx.openbank.i2.repository.RespositoryPersona;
import com.mx.openbank.i2.service.ServicePersona;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;

@Service
public class ServicePersonaImpl implements ServicePersona {

	@Autowired
	private RespositoryPersona repositoryPersona;
	
	private UtilConnector util;
	
	private ContructorEntidades contructorEntidades;

	private static final Logger Logger = LogManager.getLogger(ServicePersonaImpl.class);

	@Override
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();
		Logger.info(valor);
		util = new UtilConnector();
		contructorEntidades = new ContructorEntidades();
		String nombre = null;
		String apellido = null;
		String id_persona = null;
		
		for (HashMap<String, String> map : valor) {
			String id = map.get("id");
			String val = map.get("value");
			if ("nombres".equalsIgnoreCase(id)) {
				nombre = val;
			} else if ("apellidos".equalsIgnoreCase(id)) {
				apellido = val;
			}else if ("idCliente".equalsIgnoreCase(id)) {
				id_persona = val;
			}
		}

		if (nombre != null && apellido != null) {
			List<Persona> personas = repositoryPersona.getRegresaPerona(nombre, apellido);
			Logger.info("Resultado búsqueda: " + personas);
			for (Persona persona : personas) {
				listaEntidades.add(contructorEntidades.mapeoEntidadPersona(persona));
			}
		}
		
		
		if (nombre != null && apellido == null  && id_persona != null) {
			List<Persona>  personas = repositoryPersona.getRegresaPeronaId(id_persona);
			Logger.info("Resultado búsqueda: " + personas);
			for (Persona persona : personas) {
				listaEntidades.add(contructorEntidades.mapeoEntidadPersona(persona));
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
