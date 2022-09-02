package com.juanbastidas.appdeudas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Debts" )
public class Debt implements Serializable{

	private static final long serialVersionUID = -8265065279858571073L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_debt")
	private Long id_debt;

	@OneToOne
	@JoinColumn(name = "user_bank_id")
	private UserBank userBank;

	private int cuotas;
	
	public Long getId() {
		return id_debt;
	}

	public void setId(Long id) {
		this.id_debt = id;
	}

	public UserBank getUserBank() {
		return userBank;
	}

	public void setUserBank(UserBank userBank) {
		this.userBank = userBank;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
}
