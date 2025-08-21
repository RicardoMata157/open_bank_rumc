package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Onboarding;


@Repository
public interface RepositoryOnBoarding extends  JpaRepository<Onboarding, String> {
	
	
	@Query(nativeQuery = true, value = "select tr.cif_record_id, TO_CHAR(tr.onboarding_date, 'YYYY-MM-DD\"T\"HH24:MI:SS.MS') as onboarding_date, tr.text_value    from fcm.tah2cif_record tr"
			                         + " where text_value = :Latitud ;")
	List<Onboarding> consultaOnboarding(@Param("Latitud") String Latitud);
	
	
	@Query(nativeQuery = true, value = "select tcr.cif_record_id ,tcr.onboarding_date , tcr.text_value  "
			+ "from fcm.tah2cif_record tcr  "
			+ "where tcr.cust_id = :idUser ;")
	List<Onboarding> consultaOnboardingPersona(@Param("idUser")String usuario);
}
