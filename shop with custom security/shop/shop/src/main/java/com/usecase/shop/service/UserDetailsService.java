package com.usecase.shop.service;

import com.usecase.shop.entities.Account;
import com.usecase.shop.model.SecurityAccount;
import com.usecase.shop.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final AccountRepository accountRepository;

    public UserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = accountRepository.findAccountByUserName(username);
        return  u.map(SecurityAccount::new)
                .orElseThrow( () -> new UsernameNotFoundException("Username not found: " + username));
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
