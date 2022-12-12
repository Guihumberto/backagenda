package com.cotec.agenda.dto;

import java.io.Serializable;

import com.cotec.agenda.entities.Phone;

public class PhoneDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String phone;
	
	public PhoneDTO() {
	}

	public PhoneDTO(Long id, String phone) {
		this.id = id;
		this.phone = phone;
	}
	
	public PhoneDTO(Phone entity) {
		id = entity.getId();
		phone = entity.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
