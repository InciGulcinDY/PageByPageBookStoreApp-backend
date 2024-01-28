package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, Integer> {
    //  Derived Query Methods
    boolean existsMagazineByTitle(String title);
}
