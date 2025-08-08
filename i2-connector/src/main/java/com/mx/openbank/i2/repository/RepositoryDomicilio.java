package com.mx.openbank.i2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Domicilio;


@Repository
public interface RepositoryDomicilio extends JpaRepository<Domicilio, String> {

}
