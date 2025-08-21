package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Tarjeta;
@Repository
public interface RepositoryTarjeta extends JpaRepository<Tarjeta, String> {
	
	
	@Query(nativeQuery = true, value = "select pa.account_code, padf.id_account_field_def, padf.text_value  from pro_account pa "
			+ "inner join pro_account_dyn_field padf on pa.id=padf.id_account_record"
			+ "where pa.account_code='4001264226'"
			+ "and id_account_field_def ='CARDID'")
	String getNumeroTarjeta(String numeroCuneta);
	
	
	@Query(nativeQuery = true, value = "select id,field_name,id_account_record,text_value "
			+ " from fcm.pro_account_dyn_field "
			+ " where text_value = :numerotarjeta ; ")
	List<Tarjeta> consultaTarjeta(@Param("numerotarjeta") String numerotarjeta);



}
