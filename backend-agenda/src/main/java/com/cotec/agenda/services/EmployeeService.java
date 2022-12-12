package com.cotec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cotec.agenda.dto.EmployeeDTO;
import com.cotec.agenda.entities.Employee;
import com.cotec.agenda.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll(){
		List<Employee> list = repository.findAll();
		return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}

}
