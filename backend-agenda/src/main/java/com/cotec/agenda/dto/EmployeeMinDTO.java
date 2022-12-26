package com.cotec.agenda.dto;

import java.io.Serializable;

import com.cotec.agenda.entities.Employee;

public class EmployeeMinDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cellphone;
	private Boolean wtzp;
	private Boolean phoneTable;
	
	public EmployeeMinDTO() {
	}

	public EmployeeMinDTO(Long id, String name, String email, String cellphone, Boolean wtzp, Boolean phoneTable) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.wtzp = wtzp;
		this.phoneTable = phoneTable;
	}
	
	public EmployeeMinDTO(Employee entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.cellphone = entity.getCellphone();
		this.wtzp = entity.getWtzp();
		this.phoneTable = entity.getPhoneTable();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Boolean getWtzp() {
		return wtzp;
	}

	public void setWtzp(Boolean wtzp) {
		this.wtzp = wtzp;
	}

	public Boolean getPhoneTable() {
		return phoneTable;
	}

	public void setPhoneTable(Boolean phoneTable) {
		this.phoneTable = phoneTable;
	}

}
