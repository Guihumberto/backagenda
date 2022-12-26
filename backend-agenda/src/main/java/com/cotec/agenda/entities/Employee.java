package com.cotec.agenda.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String cellphone;
	private Boolean wtzp;
	private Boolean phoneTable;
	
	@ManyToOne
	@JoinColumn(name = "phone_id")
	private Phone phone;
	
	@ManyToOne
	@JoinColumn(name = "sector_id")
	private Sector sector;
	
	public Employee() {
	}
	
	

	public Employee(Long id, String name, String email, String cellphone, Boolean wtzp, Boolean phoneTable, Phone phone,
			Sector sector) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.wtzp = wtzp;
		this.phoneTable = phoneTable;
		this.phone = phone;
		this.sector = sector;
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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
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
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

}
