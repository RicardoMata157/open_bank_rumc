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
import com.mx.openbank.i2.service.ServiceTelefono;
import com.mx.openbank.i2.service.ServiceOnBoarding;
import com.mx.openbank.i2.service.ServiceCuentaExterna;
import com.mx.openbank.i2.service.ServiceOperacion;
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
	
	@Autowired
	private ServiceTelefono serviceTelefono;
	
	@Autowired
	private ServiceOnBoarding serviceOnBoarding;
	
	@Autowired
	private ServiceCuentaExterna serviceCuentaExterna;

	@Autowired
	private ServiceOperacion serviceOperacion;
	
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
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-cuentaexterna", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaCuentaExterna(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = serviceCuentaExterna.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-telefono", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaTelefono(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = serviceTelefono.consultaParametro(valor);
		Logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-onboarding", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaOnboarding(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = serviceOnBoarding.consultaParametro(valor);
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
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-operacion", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaOperacion(@RequestBody String query) {
		util = new UtilConnector();
		Logger.info("LLego la consulta esperada" + query);
		List<HashMap<String, String>> valor = util.extraeCadenaBusquedaJson(query);
		Logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = serviceOperacion.consultaParametro(valor);
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
	

}
