package com.inci.Page.by.Page.Book.Store.dataAccess.concretes;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
