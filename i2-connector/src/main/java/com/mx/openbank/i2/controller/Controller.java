package com.mx.openbank.i2.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

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

import com.mx.openbank.i2.service.ServicePersona;
import com.mx.openbank.i2.util.UtilConnector;

@RestController
public class Controller {

	@Value("classpath:config.json")
	private Resource configResource;
	
	private UtilConnector util;
	
	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	@Autowired
	private ServicePersona servicePersona;

	@RequestMapping(method = RequestMethod.GET, value = "/config", produces = APPLICATION_JSON_VALUE)
	public Resource config() {
		return configResource;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda-persona", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> busquedaPersona(@RequestBody String query) {
		String valor = util.extraeCadenaBusquedaJson(query);
		logger.info("LLego la consulta esperada" + valor);
		Map<String, Object> mapaEntidades = servicePersona.consultaParametro(valor);
		logger.info("Respuesta....." + mapaEntidades);
		
		return new ResponseEntity<Map<String, Object>>(mapaEntidades, HttpStatus.OK);
	}
	
	

}
