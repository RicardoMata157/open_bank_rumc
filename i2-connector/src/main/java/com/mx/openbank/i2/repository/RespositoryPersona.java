package com.mx.openbank.i2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Persona;


@Repository
public interface RespositoryPersona extends JpaRepository<Persona, String> {
	
	@Query(nativeQuery = true, value = "Select * from tah2cif_record")
	public  String getOpbernPerona(String nombre);

}
