package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Comercio;

@Repository
public interface RepositoryComercio extends JpaRepository<Comercio, String> {
	
	@Query(nativeQuery = true, value = "select pro.id, pro.manager, pro,rfc, pro.tipoComerico    from fcm.pro_operation pro"
            + " where manager = :nombrecomercio ;")
List<Comercio> consultaComercio(@Param("nombrecomercio") String nombrecomercio);	


}
