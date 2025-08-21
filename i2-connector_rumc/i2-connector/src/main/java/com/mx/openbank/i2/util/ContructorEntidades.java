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
	
	
	public Map<String, Object> mapeoEntidadDomicilio(Domicilio dataDomiclio) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT2");
		entity.put("version", 1);
		entity.put("id", dataDomiclio.getId());
        properties.put("TP16", dataDomiclio.getCalle());
		properties.put("TP18", dataDomiclio.getCiudad());
		properties.put("TP21", dataDomiclio.getCp());
		properties.put("TP22", dataDomiclio.getPais());
		properties.put("TP23", dataDomiclio.getEstado());
		properties.put("TP24", dataDomiclio.getId());
		entity.put("properties", properties);

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
	
	
	
	public Map<String, Object> mapeoEntidadOnboarding(Onboarding dataOnboarding) {
	    Map<String, Object> entity = new HashMap<>();
	    Map<String, String> properties = new HashMap<>();
	    entity.put("typeId", "TENT5");
	    entity.put("version", 1);
	    entity.put("id", dataOnboarding.getId());
	    properties.put("TP26", dataOnboarding.getFechaHora());
	    properties.put("TP28", dataOnboarding.getId());
	    properties.put("TP29", dataOnboarding.getCoordenadas());
	    entity.put("properties", properties);
	    return entity;
	}
	
	
	
	public Map<String, Object> mapeoEntidadCuentaExterna(CuentaExterna dataCuentaExterna) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT6");
		entity.put("version", 1);
		entity.put("id", dataCuentaExterna.getAccount_id());
		properties.put("TP31", dataCuentaExterna.getNumeroCuentaEntrada());
		properties.put("TP17", dataCuentaExterna.getNumeroCuentaSalida());
		properties.put("TP32", dataCuentaExterna.getNombreCompletoCliente());
		properties.put("TP35", dataCuentaExterna.getBanco());
		properties.put("TP36", dataCuentaExterna.getCuentaClabe());
		entity.put("properties", properties);
		return entity;
	}
	
	
	public Map<String, Object> mapeoEntidadOperacion(Operacion dataOperacion) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT8");
		entity.put("version", 1);
		entity.put("id", dataOperacion.getIdTransaccion());
		properties.put("TP39", dataOperacion.getFechaHora());
		properties.put("TP20", dataOperacion.getIdTransaccion());
		properties.put("TP40", dataOperacion.getClaveRastreo());
		properties.put("TP41", dataOperacion.getCodigoOperacionEntrada());
		properties.put("TP27", dataOperacion.getCodigoOperacionSalida());
		properties.put("TP42", dataOperacion.getMonto());
		properties.put("TP43", dataOperacion.getDispositivo());
		properties.put("TP44", dataOperacion.getNarrative());
		properties.put("TP30", dataOperacion.getBeneficiaryCostumerId());
		properties.put("TP34", dataOperacion.getCoordenadas());
		entity.put("properties", properties);
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
	
	
	
	public Map<String, Object> mapeoEntidadTelefono(Telefono dataTelefono) {
		Map<String, Object> entity = new HashMap<>();
		Map<String, String> properties = new HashMap<>();
		entity.put("typeId", "TENT12");
		entity.put("version", 1);
        entity.put("id", dataTelefono.getId() + dataTelefono.getNumeroTelefonico() );
		properties.put("TP14", dataTelefono.getNumeroTelefonico());
		properties.put("TP15", dataTelefono.getId() + dataTelefono.getNumeroTelefonico());

		entity.put("properties", properties);

		return entity;
	}
	
	
	

}
