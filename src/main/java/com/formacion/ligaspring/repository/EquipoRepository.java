package com.formacion.ligaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.ligaspring.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	
}
