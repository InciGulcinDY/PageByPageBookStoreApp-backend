package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.user.request.AddUserRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.user.request.LoginRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(AddUserRequest request);
    String login(LoginRequest request);
}
