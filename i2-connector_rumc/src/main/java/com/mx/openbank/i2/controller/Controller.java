package com.mx.openbank.i2.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.openbank.i2.service.ServiceDomicilio;
import com.mx.openbank.i2.service.ServicePersona;
import com.mx.openbank.i2.util.UtilConnector;

@RestController
public class Controller {

	@Value("classpath:config.json")
	private Resource configResource;
	
	private UtilConnector util;
	
	private static final Logger Logger = LogManager.getLogger(Controller.class);
	
	@Autowired
	private ServicePersona servicePersona;
	
	@Autowired
	private ServiceDomicilio serviceDomicilio;

	@RequestMapping(method = RequestMethod.GET, value = "/config", produces = APPLICATION_JSON_VALUE)
	public Resource config() {
		return configResource;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-persona", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaPersona(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-cuenta", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaCuenta(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-tarjeta", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaTarjeta(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-telefono", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaTelefono(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-domicilio", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaDomicilio(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = serviceDomicilio.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-cuentaExterna", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaCuentaExterna(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-operacion", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaOperacion(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-comercio", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaComercio(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	
	//CONTROLADOR DE EXPANSION 
	
	@RequestMapping(method = RequestMethod.POST, value = "/expansion", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> expansionEntidad(@RequestBody String json) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + json);
		 List<String> listSeed = util.extreSeedIdJson(json);
		 List<String> listSourceIds = util.extreSourceIdsJson(json);
		// Map<String, Object> mapaEntidadesLink = serviceConsulta.expansionEntidades(listSeed, listSourceIds);
		 Logger.info("La lista de id de entidades es: " + listSeed +  listSourceIds);
		//return new ResponseEntity<Map<String, Object>>(new , HttpStatus.OK);
		 return null;
	}
	
	

}
