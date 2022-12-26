package com.cotec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotec.agenda.dto.EmployeeDTO;
import com.cotec.agenda.dto.EmployeeNewDTO;
import com.cotec.agenda.entities.Employee;
import com.cotec.agenda.entities.Phone;
import com.cotec.agenda.entities.Sector;
import com.cotec.agenda.repositories.EmployeeRepository;
import com.cotec.agenda.services.exceptions.DataBaseException;
import com.cotec.agenda.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll(){
		List<Employee> list = repository.findAll();
		return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.getName());
		
		Phone phone = new Phone();
		phone.setId(dto.getPhone().getId());
		entity.setPhone(phone);
		
		Sector sector = new Sector();
		sector.setId(dto.getSector().getId());
		entity.setSector(sector);
		
		entity = repository.save(entity);
		
		return new EmployeeDTO(entity);
	}
	
	@Transactional
	public EmployeeNewDTO insert(EmployeeNewDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCellphone(dto.getCellphone());
		entity.setWtzp(dto.getWtzp());
		entity.setPhoneTable(dto.getPhoneTable());
		
		Phone phone = new Phone();
		phone.setId(dto.getPhoneId());
		entity.setPhone(phone);
		
		Sector sector = new Sector();
		sector.setId(dto.getSectorId());
		entity.setSector(sector);
		
		entity = repository.save(entity);
		
		return new EmployeeNewDTO(entity);
	}
	
	@Transactional
	public EmployeeNewDTO update(Long id, EmployeeNewDTO dto) {
		try {
			Employee entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setCellphone(dto.getCellphone());
			entity.setWtzp(dto.getWtzp());
			entity.setPhoneTable(dto.getPhoneTable());
			
			Phone phone = new Phone();
			phone.setId(dto.getPhoneId());	
			entity.setPhone(phone);
			
			Sector sector = new Sector();
			sector.setId(dto.getSectorId());
			entity.setSector(sector);
			
			entity = repository.save(entity);
			
			return new EmployeeNewDTO(entity);			
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found " + id);
		}	
		
	}
	
	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		try {
			Employee entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setCellphone(dto.getCellphone());
			entity.setWtzp(dto.getWtzp());
			entity.setPhoneTable(dto.getPhoneTable());
			
			Phone phone = new Phone();
			phone.setId(dto.getPhone().getId());	
			entity.setPhone(phone);
			
			Sector sector = new Sector();
			sector.setId(dto.getSector().getId());
			entity.setSector(sector);
			
			entity = repository.save(entity);
			
			return new EmployeeDTO(entity);			
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


}
