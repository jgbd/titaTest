/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banks" )
public class Bank implements Serializable{

	private static final long serialVersionUID = 2527895359755590119L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=50, nullable=false)
	private String name;
		
	@OneToMany(mappedBy = "bank")
    Set<UserBank> userBank;
	
	
	/**
	 * 
	 */
	public Bank() {
		super();
	}

	public Bank(String name) {
		super();
		this.name = name;
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

}
