package com.juanbastidas.appdeudas.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne
    @JoinColumn(name="user_bank_id", nullable=false)
	private UserBank userBank;
	
	private int cuotas;
	
	private Long Valor;
	
	
	
	/**
	 * 
	 */
	public Debt() {
		super();
	}

	
	/**
	 * @param cuotas
	 * @param valor
	 */
	public Debt(int cuotas, Long valor) {
		super();
		this.cuotas = cuotas;
		Valor = valor;
	}



	public Long getId() {
		return id_debt;
	}

	public void setId(Long id) {
		this.id_debt = id;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public Long getValor() {
		return Valor;
	}

	public void setValor(Long valor) {
		Valor = valor;
	}
	
	
}
