package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.CuentaExterna;


@Repository
public interface RepositoryCuentaExterna extends JpaRepository<CuentaExterna, String> {
	
	@Query(
			nativeQuery = true, 
			value = "SELECT po.ordering_customer_id, po.account_id, po.REMITTER_BANK, po.BENEFICIARY_BANK, po.EXTERNAL_NAME, po.EXTERNAL_BIC "			
			+ "FROM fcm.pro_operation po " + " WHERE po.REMITTER_BANK = :numerocuentaentrada " + "AND po.BENEFICIARY_BANK = :numerocuentasalida")
	List<CuentaExterna> getRegresaPerona(@Param("numerocuentaentrada") String nombre, @Param("numerocuentasalida") String apellido);
	
	
	@Query(
		    nativeQuery = true,
		    value = "SELECT po.ordering_customer_id, po.account_id, po.REMITTER_BANK, po.BENEFICIARY_BANK, po.EXTERNAL_NAME, po.EXTERNAL_BIC " +
		            "FROM fcm.pro_operation po " +
		            "WHERE po.EXTERNAL_NAME = :nombrecompleto"
		)
		List<CuentaExterna> getRegresaPeronaId(@Param("nombrecompleto") String idUsuario);

	
	
	
	@Query(
		    nativeQuery = true,
		    value = "SELECT po.ordering_customer_id, po.account_id, po.REMITTER_BANK, po.BENEFICIARY_BANK, po.EXTERNAL_NAME, po.EXTERNAL_BIC " +
		            "FROM fcm.pro_operation po " +
		            "WHERE po.BENEFICIARY_BANK = :numerocuentaentrada " +
		            "AND (:numerocuentasalida IS NULL OR po.REMITTER_BANK = :numerocuentasalida) " +
		            "AND (:nombrecompleto IS NULL OR po.EXTERNAL_NAME = :nombrecompleto)"
		)
		List<CuentaExterna> getPersonaFlexible(
		        @Param("numerocuentaentrada") String Numerocuentaentrada,
		        @Param("numerocuentasalida") String Numerocuentasalida,
		        @Param("nombrecompleto") String Nombrecompleto
		);

}
