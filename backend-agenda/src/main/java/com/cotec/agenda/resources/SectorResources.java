package com.cotec.agenda.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cotec.agenda.dto.EmployeeMinDTO;
import com.cotec.agenda.dto.SectorDTO;
import com.cotec.agenda.services.SectorService;

@RestController
@RequestMapping(value = "/sector")
public class SectorResources {
	
	@Autowired
	private SectorService service;
	
	@GetMapping
	public ResponseEntity<List<SectorDTO>> findAll() {
		List<SectorDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SectorDTO> findById(@PathVariable Long id){
		SectorDTO obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/{id}/employees")
	public ResponseEntity<List<EmployeeMinDTO>> findByEmployeesBySector(@PathVariable Long id){
		List<EmployeeMinDTO> list = service.findByEmployeesBySector(id);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<SectorDTO> insert(@RequestBody SectorDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SectorDTO> update(@PathVariable Long id, @RequestBody SectorDTO dto){
		dto = service.update(id, dto);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SectorDTO> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
