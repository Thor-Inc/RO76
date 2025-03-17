package com.usecase.shop.repository;

import com.usecase.shop.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a from Account a where a.userName =:#{#username}")
    Optional<Account> findAccountByUserName(String username);
}
