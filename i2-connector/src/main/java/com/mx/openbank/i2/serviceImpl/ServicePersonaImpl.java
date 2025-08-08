package com.mx.openbank.i2.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.repository.RespositoryPersona;
import com.mx.openbank.i2.service.ServicePersona;

@Service
public class ServicePersonaImpl implements ServicePersona {
	
	@Autowired
	private RespositoryPersona repositoryPersona;
	
	
	public String getPersona(String nombre) {
		return repositoryPersona.getOpbernPerona(nombre);
	}


	@Override
	public Map<String, Object> consultaParametro(String query) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
