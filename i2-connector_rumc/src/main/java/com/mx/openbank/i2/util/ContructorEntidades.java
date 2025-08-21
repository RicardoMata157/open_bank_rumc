package com.mx.openbank.i2.util;

import java.util.HashMap;
import java.util.Map;

import com.mx.openbank.i2.entity.Comercio;
import com.mx.openbank.i2.entity.Cuenta;
import com.mx.openbank.i2.entity.CuentaExterna;
import com.mx.openbank.i2.entity.Domicilio;
import com.mx.openbank.i2.entity.Onboarding;
import com.mx.openbank.i2.entity.Operacion;
import com.mx.openbank.i2.entity.Persona;
import com.mx.openbank.i2.entity.Tarjeta;
import com.mx.openbank.i2.entity.Telefono;

public class ContructorEntidades {
	
	
	public Map<String, Object> mapeoEntidadPersona(Persona dataPersona) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT1");
		entity.put("version", 1);
		entity.put("id", dataPersona.getCifRecordId());
		properties.put("TP1", dataPersona.getNombre());
		properties.put("TP2", dataPersona.getApellidos());
		properties.put("TP5", dataPersona.getIdCliente());
		properties.put("TP6", dataPersona.getTipo_persona());
		properties.put("TP51", dataPersona.getIndicadorEmpleado());
		properties.put("TP49", dataPersona.getCurp());
		properties.put("TP50", dataPersona.getIne());
		properties.put("TP48", dataPersona.getRfc());
		properties.put("TP7", dataPersona.getCategoriaPersona());
		properties.put("TP8", dataPersona.getPaisNacimiento());
		properties.put("TP52", dataPersona.getFechaNacimiento());
		properties.put("TP53", dataPersona.getRiesgoCliente());
		entity.put("properties", properties);

		return entity;
	}
	
	
	public Map<String, Object> mapeoEntidadDomicilio(Domicilio dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT2");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
        properties.put("TP16", dataCuenta.getCalle());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	public Map<String, Object> mapeoEntidadComercio(Comercio dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT3");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
//		properties.put("TP1", dataPersona.getNombre());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	
	public Map<String, Object> mapeoEntidadOnboarding(Onboarding dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT5");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
//		properties.put("TP1", dataPersona.getNombre());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	
	public Map<String, Object> mapeoEntidadCuentaExterna(CuentaExterna dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT6");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
//		properties.put("TP1", dataPersona.getNombre());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	public Map<String, Object> mapeoEntidadOperacion(Operacion dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT8");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
//		properties.put("TP1", dataPersona.getNombre());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	
	public Map<String, Object> mapeoEntidadCuenta(Cuenta dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT10");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
//		properties.put("TP1", dataPersona.getNombre());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	
	public Map<String, Object> mapeoEntidadTarjeta(Tarjeta dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT11");
		entity.put("version", 1);
//		entity.put("id", dataPersona.getCifRecordId());
//		properties.put("TP1", dataPersona.getNombre());
//		properties.put("TP2", dataPersona.getApellidos());
//		properties.put("TP5", dataPersona.getIdCliente());
//		properties.put("TP6", dataPersona.getTipo_persona());
//		properties.put("TP51", dataPersona.getIndicadorEmpleado());
//		properties.put("TP49", dataPersona.getCurp());
//		properties.put("TP50", dataPersona.getIne());
//		properties.put("TP48", dataPersona.getRfc());
//		properties.put("TP7", dataPersona.getCategoriaPersona());
//		properties.put("TP8", dataPersona.getPaisNacimiento());
//		properties.put("TP52", dataPersona.getFechaNacimiento());
//		properties.put("TP53", dataPersona.getRiesgoCliente());
//		entity.put("properties", properties);

		return entity;
	}
	
	
	
	public Map<String, Object> mapeoEntidadTelefono(Telefono dataCuenta) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT11");
		entity.put("version", 1);
        entity.put("id", dataCuenta.getId() + dataCuenta.getNumeroTelefonico() );
		properties.put("TP14", dataCuenta.getNumeroTelefonico());
		properties.put("TP15", dataCuenta.getId() + dataCuenta.getNumeroTelefonico());

		entity.put("properties", properties);

		return entity;
	}
	
	
	

}
