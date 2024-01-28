package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // DERIVED QUERY METHODS
    Optional<User> findByEmail(String email);
}
