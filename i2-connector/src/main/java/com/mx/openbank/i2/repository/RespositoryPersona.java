package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Persona;

@Repository
public interface RespositoryPersona extends JpaRepository<Persona, String> {

	@Query(
			  nativeQuery = true,
			  value =
			    "SELECT tr.cif_record_id, tr.cust_id, tr.first_name, tr.name, tr.pep, tr.passport_nr, " +
			    "       tr.nat_id, tr.ssn_id, tr.classification, tr.birth_country, tr.birth_date, " +
			    "       tr.risk_level," +
			    "       CASE " +
			    "         WHEN trim(tr.risk_level) ~ '^[0-9]+$' THEN " +
			    "           CASE " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) <= 20 THEN 'Muy Bajo' " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 21 AND 28 THEN 'Bajo' " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 29 AND 75 THEN 'Medio' " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 76 AND 206 THEN 'Alto' " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 207 AND 377 THEN 'Bajo' " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 378 AND 507 THEN 'Medio' " +
			    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 508 AND 25000 THEN 'Alto' " +
			    "           END " +
			    "         ELSE NULL " +
			    "       END AS statusRiesgo " +
			    "FROM fcm.tah2cif_record tr " +
			    "WHERE tr.first_name = :nombres AND tr.name = :apellidos"
			)
			List<Persona> getRegresaPerona(@Param("nombres") String nombre,
			                               @Param("apellidos") String apellido);



	
	
	@Query(
		    nativeQuery = true,
		    value = "SELECT tr.cif_record_id, tr.cust_id, tr.first_name, tr.name, tr.pep, tr.passport_nr, " +
		            "tr.nat_id, tr.ssn_id, tr.classification, tr.birth_country, tr.birth_date, tr.risk_level,"+
		            "       CASE " +
				    "         WHEN trim(tr.risk_level) ~ '^[0-9]+$' THEN " +
				    "           CASE " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) <= 20 THEN 'Muy Bajo' " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 21 AND 28 THEN 'Bajo' " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 29 AND 75 THEN 'Medio' " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 76 AND 206 THEN 'Alto' " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 207 AND 377 THEN 'Bajo' " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 378 AND 507 THEN 'Medio' " +
				    "             WHEN CAST(trim(tr.risk_level) AS INTEGER) BETWEEN 508 AND 25000 THEN 'Alto' " +
				    "           END " +
				    "         ELSE NULL " +
				    "       END AS statusRiesgo " +
		            "FROM fcm.tah2cif_record tr " +
		            "WHERE tr.cust_id = :id_usuario"
		)
		List<Persona> getRegresaPeronaId(@Param("id_usuario") String idUsuario);

	
	
	
	@Query(
		    nativeQuery = true,
		    value = "SELECT tr.cif_record_id, tr.cust_id, tr.first_name, tr.name, tr.pep, tr.passport_nr, " +
		            "tr.nat_id, tr.ssn_id, tr.classification, tr.birth_country, tr.birth_date, tr.risk_level, tr.indicador_empleado " +
		            "FROM fcm.tah2cif_record tr " +
		            "WHERE tr.first_name = :nombres " +
		            "AND (:apellidos IS NULL OR tr.name = :apellidos) " +
		            "AND (:id_usuario IS NULL OR tr.cust_id = :id_usuario)"
		)
		List<Persona> getPersonaFlexible(
		        @Param("nombres") String nombre,
		        @Param("apellidos") String apellido,
		        @Param("id_usuario") String idUsuario
		);
	
	
	
	 @Query(
		        nativeQuery = true,
		        value = "SELECT tr.cif_record_id, tr.cust_id, tr.first_name, tr.name, tr.pep, tr.passport_nr, " +
		                "tr.nat_id, tr.ssn_id, tr.classification, tr.birth_country, tr.birth_date, tr.risk_level, tr.indicador_empleado " +
		                "FROM fcm.tah2cif_record tr " +
		                "WHERE (:nombres IS NULL OR tr.first_name = :nombres) " +
		                "AND (:apellidos IS NULL OR tr.name = :apellidos) " +
		                "AND (:id_usuario IS NULL OR tr.cust_id = :id_usuario) " +
		                "AND (:pais_nacimiento IS NULL OR tr.birth_country = :pais_nacimiento)"
		    )
		    List<Persona> getPersonaFlexible(
		        @Param("nombres") String nombre,
		        @Param("apellidos") String apellido,
		        @Param("id_usuario") String idUsuario,
		        @Param("pais_nacimiento") String paisNacimiento
		    );


}
