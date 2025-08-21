package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Domicilio;


@Repository
public interface RepositoryDomicilio extends JpaRepository<Domicilio, String> {
	
	
	@Query(nativeQuery = true, value = "select tr.cif_record_id ,tr.address1 ,tr.city ,tr.zipcode ,tr.country , tr.state   from fcm.tah2cif_record tr\r\n"
			+ "where zipcode = :cp and city = :ciudad ;")
	List<Domicilio> consultaDomicio(@Param("cp") String cp, @Param("ciudad") String ciudad);
	
	
	
	
	@Query(nativeQuery = true, value = "select tcr.cif_record_id,tcr.address1 , tcr.city ,tcr.zipcode , tcr.country , tcr.state "
			+ "from FCM.tah2cif_record tcr "
			+ "where tcr.cust_id = :idUser")
	List<Domicilio> consultaDomicilioPersona(@Param("idUser") String id);
	

}
