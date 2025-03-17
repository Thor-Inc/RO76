package com.usecase.shop.model;

import com.usecase.shop.entities.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityAccount implements UserDetails {

    private final Account account;

    public SecurityAccount(Account user) {
        this.account = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return account.getAuthorities();
    }

    @Override
    public String getPassword() {
        return account.getEncrytedPassword();
    }

    @Override
    public String getUsername() {
        return account.getUserName();
    }
}
