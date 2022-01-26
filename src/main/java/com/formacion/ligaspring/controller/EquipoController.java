package com.formacion.ligaspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.ligaspring.entity.Equipo;
import com.formacion.ligaspring.service.EquipoService;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
	
	@Autowired
	private EquipoService equipoService;
	
	//Create a new team
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Equipo equipo){ 
		return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.save(equipo));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long id){
		Optional<Equipo> oEquipo = equipoService.findById(id);
		if (!oEquipo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oEquipo);
		
	}
	
	@PutMapping("/{id}")
	 public ResponseEntity<?> update(@RequestBody Equipo equipo, 
			 						@PathVariable(value="id") Long equipoId){
		Optional<Equipo> oEquipo = equipoService.findById(equipoId);
		if (!oEquipo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oEquipo.get().setNombre(equipo.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(equipoService.save(oEquipo.get()));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Equipo> oEquipo = equipoService.findById(id);
		if (!oEquipo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		equipoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Equipo> readAll(){
		return equipoService.findAll();
	}
	
}
