package com.inci.Page.by.Page.Book.Store.services.dtos.user.request;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String email;
    private String password;
    private String username;
    private List<Role> role;
}
