package com.juanbastidas.appdeudas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juanbastidas.appdeudas.entity.User;
import com.juanbastidas.appdeudas.entity.UserBank;

@Repository
public interface UserBankRepository extends JpaRepository<UserBank, Long> {
	List<UserBank> findByUser_Id(Long id_user);
}
