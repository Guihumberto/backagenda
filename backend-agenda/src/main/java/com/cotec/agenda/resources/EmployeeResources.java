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

import com.cotec.agenda.dto.EmployeeDTO;
import com.cotec.agenda.dto.EmployeeNewDTO;
import com.cotec.agenda.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeResources {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		List<EmployeeDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeNewDTO> insert(@RequestBody EmployeeNewDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeNewDTO> update(@PathVariable Long id, @RequestBody EmployeeNewDTO dto){
		dto = service.update(id, dto);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
