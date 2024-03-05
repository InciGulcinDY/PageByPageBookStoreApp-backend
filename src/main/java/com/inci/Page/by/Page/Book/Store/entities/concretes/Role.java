package com.inci.Page.by.Page.Book.Store.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN,
    MODERATOR,
    CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
