package com.formacion.ligaspring.service.impl;

import java.util.List;
import java.util.Optional;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.ligaspring.entity.Equipo;
import com.formacion.ligaspring.repository.EquipoRepository;
import com.formacion.ligaspring.service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService{

	@Autowired
	private EquipoRepository equipoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Equipo> findAll() { 
		return equipoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Equipo> findAll(Pageable pageable) { 
		return equipoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Equipo> findById(Long id) { 
		return equipoRepository.findById(id);
	}

	@Override
	@Transactional
	public Equipo save(Equipo equipo) { 
		return equipoRepository.save(equipo);
	}

	@Override
	@Transactional
	public void deleteById(Long id) { 
		equipoRepository.deleteById(id);
	}

}
