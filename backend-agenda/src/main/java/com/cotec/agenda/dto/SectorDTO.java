package com.cotec.agenda.dto;

import java.io.Serializable;

import com.cotec.agenda.entities.Sector;

public class SectorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	private LocalizationDTO localization;
	
	public SectorDTO() {	
	}

	public SectorDTO(Long id, String name, LocalizationDTO localization) {
		this.id = id;
		this.name = name;
		this.localization = localization;
	}
	
	public SectorDTO(Sector entity) {
		id = entity.getId();
		name = entity.getName();
		localization = new LocalizationDTO(entity.getIdlocal());
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

	public LocalizationDTO getLocalization() {
		return localization;
	}

	public void setLocalization(LocalizationDTO localization) {
		this.localization = localization;
	}

}
