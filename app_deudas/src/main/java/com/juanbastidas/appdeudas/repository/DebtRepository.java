package com.juanbastidas.appdeudas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juanbastidas.appdeudas.entity.Debt;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long>{
	@Query(value = "SELECT id_debt, valor, cuotas, user_bank_id, ub.id FROM "
			+ "db_deudas.debts d inner join db_deudas.user_bank ub on "
			+ " d.user_bank_id = ub.id"
			+ " WHERE user_bank_id =?1", nativeQuery = true)
	List<Debt> findByUserBank_Id(Long userBankId); 
}
