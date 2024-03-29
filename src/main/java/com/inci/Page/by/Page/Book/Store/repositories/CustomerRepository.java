package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //JPQL Method
    boolean existsCustomerByCityId(int id);
    boolean existsCustomerByEmail(String email);
}
