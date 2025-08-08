package com.mx.openbank.i2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.CuentaExterna;

@Repository
public interface RepositoryCuentaExterna extends JpaRepository<CuentaExterna, String> {

}
