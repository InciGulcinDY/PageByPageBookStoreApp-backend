package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    //  Derived Query Methods

    //  JPQL Methods


}
