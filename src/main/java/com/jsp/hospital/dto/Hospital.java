package com.jsp.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital {
	@Id
	private int id;
	
	@NotNull(message= "name should not be null")
	@NotBlank(message= "name should not be blank")
	private String name;
	
	@NotNull(message= "ceo sholud not be null")
	@NotBlank(message= "ceo should not be null")
	private  String ceo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", ceo=" + ceo + "]";
	}
	

}
