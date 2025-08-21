package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.entity.Onboarding;
import com.mx.openbank.i2.repository.RepositoryOnBoarding;
import com.mx.openbank.i2.service.ServiceOnBoarding;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.UtilConnector;


@Service
public class ServiceOnboardingImpl implements ServiceOnBoarding {
	@Autowired
	private RepositoryOnBoarding repositoryOnBoarding;

	private static final Logger Logger = LogManager.getLogger(ServiceOnboardingImpl.class);

	private UtilConnector util;

	private ContructorEntidades contructorEntidades;

	@Override
	public Map<String, Object> consultaParametro(List<HashMap<String, String>> valor) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();
		Logger.info(valor);
		util = new UtilConnector();
		contructorEntidades = new ContructorEntidades();
		String Latitud = null;

		for (HashMap<String, String> map : valor) {
			String id = map.get("id");
			String val = map.get("value");
			if ("Latitud".equalsIgnoreCase(id)) {
				Latitud = val;
			}
		}
		
		if (Latitud != null ) {
			List<Onboarding> onboardings = repositoryOnBoarding.consultaOnboarding(Latitud);
			Logger.info("Resultado búsqueda: " + onboardings);
			for (Onboarding onboarding : onboardings) {
				listaEntidades.add(contructorEntidades.mapeoEntidadOnboarding(onboarding));
			}
		}
		

		Map<String, Object> response = util.generateResponse(listaEntidades);


		return response;
	}

	@Override
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource) {
		// TODO Auto-generated method stub
		return null;
	}
}
