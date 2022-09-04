/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juanbastidas.appdeudas.entity.Debt;
import com.juanbastidas.appdeudas.response.DebtResponse;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long>{
	@Query(value = "SELECT"
			+ " NEW com.juanbastidas.appdeudas.response.DebtResponse(d.id as idDeuda, d.Valor as valor, b.id as idBank, d.cuotas as cuotas)  FROM"
			+ " Debt d inner join UserBank ub on"
			+ " d.userBank.id = ub.id"
			+ " join Bank b on"
			+ " ub.bank.id = b.id"
			+ " WHERE user_bank_id =?1")
	List<DebtResponse> findByUserBank_Id(Long userBankId); 
}
