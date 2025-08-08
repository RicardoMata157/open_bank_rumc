package com.mx.openbank.i2.service;

import java.util.List;
import java.util.Map;

public interface ServicePersona {

	public Map<String, Object> consultaParametro(String query);

	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource);

}
