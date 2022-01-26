package com.formacion.ligaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.formacion.ligaspring.entity.Equipo;

public interface EquipoService {
	
	public List<Equipo> findAll();
	
	public Page<Equipo> findAll(Pageable pageable); 
	
	public Optional<Equipo> findById(Long id);
	
	public Equipo save(Equipo equipo);
	
	public void deleteById(Long id);
}
