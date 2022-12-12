package com.cotec.agenda.dto;

import java.io.Serializable;
import java.util.Objects;

import com.cotec.agenda.entities.Localization;

public class LocalizationDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String adress;
	private String city;
	private String type;
	private String floor;
	
	public LocalizationDTO () {
	}

	public LocalizationDTO(Long id, String adress, String city, String type, String floor) {
		this.id = id;
		this.adress = adress;
		this.city = city;
		this.type = type;
		this.floor = floor;
	}
	
	public LocalizationDTO(Localization entity) {
		this.id = entity.getId();
		this.adress = entity.getAdress();
		this.city = entity.getCity();
		this.type = entity.getType();
		this.floor = entity.getFloor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalizationDTO other = (LocalizationDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
