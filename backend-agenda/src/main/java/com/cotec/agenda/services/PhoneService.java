package com.cotec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotec.agenda.dto.PhoneDTO;
import com.cotec.agenda.entities.Phone;
import com.cotec.agenda.repositories.PhoneRepository;
import com.cotec.agenda.services.exceptions.DataBaseException;
import com.cotec.agenda.services.exceptions.ResourceNotFoundException;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneRepository repository;
	
	@Transactional(readOnly = true)
	public List<PhoneDTO> findAll(){
		List<Phone> list = repository.findAll();
		return list.stream().map(x -> new PhoneDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public PhoneDTO insert(PhoneDTO dto) {
		Phone entity = new Phone();
		entity.setPhone(dto.getPhone());
		entity = repository.save(entity);
		
		return new PhoneDTO(entity);
	}
	
	@Transactional
	public PhoneDTO update(Long id, PhoneDTO dto) {
		try {
			Phone entity = repository.getReferenceById(id);
			entity.setPhone(dto.getPhone());
			entity = repository.save(entity);
			return new PhoneDTO(entity);			
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id nor Found " + id);
		}	
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id nor Found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Integration violation");
		}
		
	}

}
