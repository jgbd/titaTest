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
@Table(name = "users" )
public class User implements Serializable{
	
	private static final long serialVersionUID = -3429635984507024935L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	@Column(length=50, nullable=false)
	private String name;
	private Boolean enabled;
	
	@OneToMany(mappedBy = "user")
    Set<UserBank> userBank;
	
	public User(String name, Boolean enabled) {
		super();
		this.name = name;
		this.enabled = enabled;
	}
	
	public Long getId() {
		return id_user;
	}
	public void setId(Long id) {
		this.id_user = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
