/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.response;

public class DebtResponse {
	private Long idDebt;
	private Long valor;
	private Long idBank;
	private int cuotas;
	

	public DebtResponse(Long idDebt, Long valor, Long idBank, int cuotas) {
		super();
		this.idDebt = idDebt;
		this.valor = valor;
		this.idBank = idBank;
		this.cuotas = cuotas;
	}
	
	public Long getIdDebt() {
		return idDebt;
	}

	public void setIdDebt(Long idDebt) {
		this.idDebt = idDebt;
	}

	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public Long getIdBank() {
		return idBank;
	}
	public void setIdBank(Long idBank) {
		this.idBank = idBank;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	@Override
	public String toString() {
		return "DebtResponse [valor=" + valor + ", idBank=" + idBank + ", cuotas=" + cuotas + "]";
	}
	
	
}
