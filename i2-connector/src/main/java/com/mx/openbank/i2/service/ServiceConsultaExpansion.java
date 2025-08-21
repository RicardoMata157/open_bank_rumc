package com.mx.openbank.i2.service;

import java.util.List;
import java.util.Map;

public interface ServiceConsultaExpansion {
		
	
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource,List<String> listTypeId);

}
