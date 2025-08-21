package com.mx.openbank.i2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ServiceCuenta {
	
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor);

	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource);
}