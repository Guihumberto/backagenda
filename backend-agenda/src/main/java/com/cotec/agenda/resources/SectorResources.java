package com.cotec.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
