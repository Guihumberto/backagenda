package com.cotec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotec.agenda.dto.LocalizationDTO;
import com.cotec.agenda.entities.Localization;
import com.cotec.agenda.repositories.LocalizationRepository;
import com.cotec.agenda.services.exceptions.DataBaseException;
import com.cotec.agenda.services.exceptions.ResourceNotFoundException;

@Service
public class LocalizationService {
	
	@Autowired
	private LocalizationRepository repository;
	
	@Transactional(readOnly = true)
	public List<LocalizationDTO> findAll(){
		List<Localization> list = repository.findAll();
		return list.stream().map(x -> new LocalizationDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public LocalizationDTO insert(LocalizationDTO dto) {
		Localization entity = new Localization();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new LocalizationDTO(entity);
	}
	
	@Transactional
	public LocalizationDTO update(Long id, LocalizationDTO dto) {
		try {
			Localization entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new LocalizationDTO(entity);			
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
	
	private void copyDtoToEntity(LocalizationDTO dto, Localization entity) {
		entity.setAdress(dto.getAdress());
		entity.setCity(dto.getCity());
		entity.setFloor(dto.getFloor());
		entity.setType(dto.getType());
	}

}
