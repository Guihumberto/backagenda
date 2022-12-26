package com.cotec.agenda.dto;

import com.cotec.agenda.entities.Employee;

public class EmployeeNewDTO {
	private Long id;
	private String name;
	private String email;
	private String cellphone;
	private Boolean wtzp;
	private Boolean phoneTable;
	private Long phoneId;
	private Long SectorId;
	
	public EmployeeNewDTO(Long id, String name, String email, String cellphone, Boolean wtzp, Boolean phoneTable,
			Long phoneId, Long sectorId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.wtzp = wtzp;
		this.phoneTable = phoneTable;
		this.phoneId = phoneId;
		SectorId = sectorId;
	}
	
	public EmployeeNewDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cellphone = entity.getCellphone();
		wtzp = entity.getWtzp();
		phoneTable = entity.getPhoneTable();
		phoneId = entity.getPhone().getId();
		SectorId = entity.getSector().getId();
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

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public Long getSectorId() {
		return SectorId;
	}

	public void setSectorId(Long sectorId) {
		SectorId = sectorId;
	}
	
	
}
