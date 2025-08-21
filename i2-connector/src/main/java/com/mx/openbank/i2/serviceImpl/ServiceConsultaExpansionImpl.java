package com.mx.openbank.i2.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.openbank.i2.entity.Cuenta;
import com.mx.openbank.i2.repository.RepositoryDomicilio;
import com.mx.openbank.i2.repository.RepositoryOnBoarding;
import com.mx.openbank.i2.repository.RepositoryTelefono;
import com.mx.openbank.i2.repository.RespositoryPersona;
import com.mx.openbank.i2.service.ServiceConsultaExpansion;
import com.mx.openbank.i2.util.ContructorEntidades;
import com.mx.openbank.i2.util.LinkUtils;

@Service
public class ServiceConsultaExpansionImpl implements ServiceConsultaExpansion {

	@Autowired
	private RepositoryDomicilio repositoryDomicilio;
	
	
	@Autowired
	private RepositoryTelefono repositoryTelefono;
	
	@Autowired
	private RepositoryOnBoarding repositoryOnBoarding;
	
	
	
	@Autowired
	private RespositoryPersona respositoryPersona;
	
	

	final String TYPE_PERSONA = "TENT1";
	final String TYPE_DOMICILIO = "TENT6"; // ajusta si tu tipo de domicilio es otro
	final String LINK_ASOCIADO = "TENL1";
	String fromEndId = "";

	@Override
	public Map<String, Object> expansionEntidades(List<String> listaSeend, List<String> listaSource,
			List<String> listTypeId) {
		List<Map<String, Object>> listaEntidades = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listaLinks = new ArrayList<Map<String, Object>>();

		ContructorEntidades constructores = new ContructorEntidades();
		for (String seed : listaSeend) {
			fromEndId = seed;
		}
		for (String typeID : listTypeId) {
			if (typeID.equals("TENT1")) {
				listaSource.stream().forEach(seed -> {
					
					respositoryPersona.getRegresaPeronaId(seed).stream().forEach(persona -> {
						persona.getOperaciones().stream().forEach(operacion -> {
							Cuenta cuenta = operacion.getCuenta();
							Map<String, Object> entidadCuenta = constructores.mapeoEntidadCuenta(cuenta);
							listaEntidades.add(entidadCuenta);
							String toEndId = String.valueOf(entidadCuenta.get("id"));
							Map<String, Object> propsLink = new HashMap<>();

							Map<String, Object> link = LinkUtils.buildLink(LINK_ASOCIADO, // typeId del link
									fromEndId, // origen
									toEndId, // destino
									typeID, // typeId entidad origen
									"TENT2", // typeId entidad destino
									seed, // para id único
									propsLink, // propiedades del link
									"Asociado" // etiqueta opcional
							);

							listaLinks.add(link);
						});
					});
					
					
					
					repositoryDomicilio.consultaDomicilioPersona(seed).stream().forEach(domicilio -> {
						Map<String, Object> entidadDomicilio = constructores.mapeoEntidadDomicilio(domicilio);
						listaEntidades.add(entidadDomicilio);
						String toEndId = String.valueOf(entidadDomicilio.get("id"));
						Map<String, Object> propsLink = new HashMap<>();

						Map<String, Object> link = LinkUtils.buildLink(LINK_ASOCIADO, // typeId del link
								fromEndId, // origen
								toEndId, // destino
								typeID, // typeId entidad origen
								"TENT2", // typeId entidad destino
								seed, // para id único
								propsLink, // propiedades del link
								"Asociado" // etiqueta opcional
						);

						listaLinks.add(link);

					});
					repositoryTelefono.consultaTelefonoPersona(seed).stream().forEach(telefono -> {
						Map<String, Object> entidadTelefono = constructores.mapeoEntidadTelefono(telefono);
						listaEntidades.add(entidadTelefono);
						String toEndId = String.valueOf(entidadTelefono.get("id"));
						Map<String, Object> propsLink = new HashMap<>();
						
						Map<String, Object> link = LinkUtils.buildLink(LINK_ASOCIADO, // typeId del link
								fromEndId, // origen
								toEndId, // destino
								typeID, // typeId entidad origen
								"TENT12", // typeId entidad destino
								seed, // para id único
								propsLink, // propiedades del link
								"Asociado" // etiqueta opcional
						);

						listaLinks.add(link);
						
						
						
						
					});
					
					repositoryOnBoarding.consultaOnboardingPersona(seed).stream().forEach(onBoarding -> {
						Map<String, Object> entidadOnBoarding = constructores.mapeoEntidadOnboarding(onBoarding);
						listaEntidades.add(entidadOnBoarding);
						String toEndId = String.valueOf(entidadOnBoarding.get("id"));
						Map<String, Object> propsLink = new HashMap<>();
						Map<String, Object> link = LinkUtils.buildLink(LINK_ASOCIADO, // typeId del link
								fromEndId, // origen
								toEndId, // destino
								typeID, // typeId entidad origen
								"TENT5", // typeId entidad destino
								seed, // para id único
								propsLink, // propiedades del link
								"Asociado" // etiqueta opcional
						);

						listaLinks.add(link);
					});

				});

			}
		}

		return generateResponseLinks(listaEntidades, listaLinks);
	}

	private Map<String, Object> generateResponseLinks(List<Map<String, Object>> entities,
			List<Map<String, Object>> links) {
		// Crear el mapa principal que contendrá la clave "entities"
		Map<String, Object> response = new HashMap<>();
		response.put("entities", entities); // Agregar la lista de entidades al mapa
		response.put("links", links);
		return response;
	}

}
