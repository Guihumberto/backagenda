package com.cotec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotec.agenda.dto.SectorDTO;
import com.cotec.agenda.entities.Sector;
import com.cotec.agenda.repositories.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	private SectorRepository repository;
	
	@Transactional(readOnly = true)
	public List<SectorDTO> findAll(){
		List<Sector> list = repository.findAll();
		return list.stream().map(x -> new SectorDTO(x)).collect(Collectors.toList());
	}

}
