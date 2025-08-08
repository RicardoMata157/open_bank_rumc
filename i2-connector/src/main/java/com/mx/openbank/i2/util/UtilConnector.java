package com.mx.openbank.i2.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilConnector {

	public String extraeCadenaBusquedaJson(String cadena) {
		ObjectMapper objectMapper = new ObjectMapper();
		String value = "";
		try {
			JsonNode rootNode = objectMapper.readTree(cadena);
			// Navegar por las propiedades
			JsonNode conditionsNode = rootNode.path("payload").path("conditions");

			for (JsonNode condition : conditionsNode) {
				String id = condition.path("id").asText();
				String logicalType = condition.path("logicalType").asText();
				value = condition.path("value").asText();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public Map<String, Object> generateResponse(List<Map<String, Object>> entities) {
		// Crear el mapa principal que contendrá la clave "entities"
		Map<String, Object> response = new HashMap<>();
		response.put("entities", entities); // Agregar la lista de entidades al mapa
		return response;
	}

	public Map<String, Object> generateResponseLinks(List<Map<String, Object>> entities,
			List<Map<String, Object>> links) {
		// Crear el mapa principal que contendrá la clave "entities"
		Map<String, Object> response = new HashMap<>();
		response.put("entities", entities); // Agregar la lista de entidades al mapa
		response.put("links", links);
		return response;
	}

}
