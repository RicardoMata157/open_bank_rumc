package com.mx.openbank.i2.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilConnector {
	
	
	public List<HashMap<String, String>> extraeCadenaBusquedaJson(String cadena) {
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<HashMap<String, String>> listaValores = new ArrayList<>();

	    try {
	        JsonNode rootNode = objectMapper.readTree(cadena);
	        JsonNode conditionsNode = rootNode.path("payload").path("conditions");

	        for (JsonNode condition : conditionsNode) {
	            HashMap<String, String> map = new HashMap<>();
	            map.put("id", condition.path("id").asText());
	            map.put("logicalType", condition.path("logicalType").asText());
	            map.put("value", condition.path("value").asText());
	            listaValores.add(map);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return listaValores;
	}


//	public String extraeCadenaBusquedaJson(String cadena) {
//		ObjectMapper objectMapper = new ObjectMapper();
//		String value = "";
//		try {
//			JsonNode rootNode = objectMapper.readTree(cadena);
//			// Navegar por las propiedades
//			JsonNode conditionsNode = rootNode.path("payload").path("conditions");
//
//			for (JsonNode condition : conditionsNode) {
//				String id = condition.path("id").asText();
//				String logicalType = condition.path("logicalType").asText();
//				value = condition.path("value").asText();
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return value;
//	}

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
	
	
	public List<String> extreSeedIdJson(String cadena) {
		ObjectMapper objectMapper = new ObjectMapper();
		 String value = "";
		 List<String> listSeed = new ArrayList<String>();
		 try {
			 JsonNode rootNode = objectMapper.readTree(cadena);
		        // Navegar por las propiedades
		        JsonNode conditionsNode = rootNode.path("payload").path("seeds").path("entities");
		        for (JsonNode condition : conditionsNode) {
		        	 value = condition.path("seedId").asText();
		        	 listSeed.add(value);
		        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSeed;
	}
	
	
	public List<String> extreSourceIdsJson(String cadena){
		ObjectMapper objectMapper = new ObjectMapper();
		 String value = "";
		 List<String> sourceIdsList = new ArrayList<String>();
		 try {
			 JsonNode rootNode = objectMapper.readTree(cadena);
		        // Navegar por las propiedades
		        JsonNode conditionsNode = rootNode.path("payload").path("seeds").path("entities");
		        for (JsonNode condition : conditionsNode) {
		        	 value = condition.path("sourceIds").path(0).path("key").path(2).asText();
		        	 sourceIdsList.add(value);
		        }
		        
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 return sourceIdsList;
	}
	

}
