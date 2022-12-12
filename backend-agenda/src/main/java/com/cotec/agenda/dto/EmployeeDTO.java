package com.cotec.agenda.dto;

import java.io.Serializable;

import com.cotec.agenda.entities.Employee;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cellphone;
	private Boolean wtzp;
	private Boolean phoneTable;
	
	private PhoneDTO phone;
	private SectorDTO sector;
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String name, String email, String cellphone, Boolean wtzp, Boolean phoneTable, 
			SectorDTO sector, PhoneDTO phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.wtzp = wtzp;
		this.phoneTable = phoneTable;
		this.phone = phone;
		this.sector = sector;
	}
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cellphone = entity.getCellphone();
		wtzp = entity.getWtzp();
		phoneTable = entity.getPhoneTable();
		phone = new PhoneDTO(entity.getIdphone());
		sector = new SectorDTO(entity.getIdsector());
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

	public PhoneDTO getPhone() {
		return phone;
	}

	public void setIdphone(PhoneDTO phone) {
		this.phone = phone;
	}

	public SectorDTO getSector() {
		return sector;
	}

	public void setSector(SectorDTO sector) {
		this.sector = sector;
	}
	
}
