package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Telefono;

@Repository
public interface RepositoryTelefono extends  JpaRepository<Telefono, String>{
	
	
	@Query(nativeQuery = true, value = "select tr.cif_record_id, tr.telno_fix    from fcm.tah2cif_record tr"
			                         + "where telno_fix = :numero;")
	List<Telefono> consultaTelefono(@Param("numero") String numero);

}
