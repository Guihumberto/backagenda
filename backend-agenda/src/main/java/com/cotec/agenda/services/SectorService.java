package com.cotec.agenda.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotec.agenda.dto.EmployeeMinDTO;
import com.cotec.agenda.dto.SectorDTO;
import com.cotec.agenda.entities.Employee;
import com.cotec.agenda.entities.Localization;
import com.cotec.agenda.entities.Sector;
import com.cotec.agenda.repositories.SectorRepository;
import com.cotec.agenda.services.exceptions.DataBaseException;
import com.cotec.agenda.services.exceptions.ResourceNotFoundException;

@Service
public class SectorService {
	
	@Autowired
	private SectorRepository repository;
	
	public SectorDTO findById(Long id) {
			Optional<Sector> result = repository.findById(id);
	
			return new SectorDTO(result.get());
	}
	
	@Transactional(readOnly = true)
	public List<SectorDTO> findAll(){
		List<Sector> list = repository.findAll();
		return list.stream().map(x -> new SectorDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public SectorDTO insert(SectorDTO dto) {
		Sector entity = new Sector();
		entity.setName(dto.getName());
		
		Localization local = new Localization();
		local.setId(dto.getLocalization().getId());
		
		entity.setIdlocal(local);
		
		entity = repository.save(entity);
		
		return new SectorDTO(entity);
	}
	
	@Transactional
	public SectorDTO update(Long id, SectorDTO dto) {
		try {
			Sector entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			
			Localization local = new Localization();
			local.setId(dto.getLocalization().getId());
			
			entity.setIdlocal(local);
			
			entity = repository.save(entity);
			
			return new SectorDTO(entity);			
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found " + id);
		}	
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not Found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Integration violation");
		}
		
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeMinDTO> findByEmployeesBySector(Long id) {
		Optional<Sector> result = repository.findById(id);
		List<Employee> list = result.get().getEmployee();
		return list.stream().map(x -> new EmployeeMinDTO(x)).toList();
	}


}
