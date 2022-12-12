package com.cotec.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cotec.agenda.dto.EmployeeDTO;
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
}
