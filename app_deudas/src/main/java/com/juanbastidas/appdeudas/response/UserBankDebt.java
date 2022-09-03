package com.juanbastidas.appdeudas.response;

import java.util.List;

import com.juanbastidas.appdeudas.entity.Bank;
import com.juanbastidas.appdeudas.entity.Debt;
import com.juanbastidas.appdeudas.entity.User;

public class UserBankDebt {
	private User user;
	private List<Bank> lstBanks;
	private List<List<Debt>> lstDebts;

	public UserBankDebt(User user, List<Bank> lstBanks, List<List<Debt>> lstDebts) {
		this.user = user;
		this.lstBanks = lstBanks;
		this.lstDebts = lstDebts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Bank> getLstBanks() {
		return lstBanks;
	}
	public void setLstBanks(List<Bank> lstBanks) {
		this.lstBanks = lstBanks;
	}
	public List<List<Debt>> getLstDebts() {
		return lstDebts;
	}
	public void setLstDebts(List<List<Debt>> lstDebts) {
		this.lstDebts = lstDebts;
	}
	
}
