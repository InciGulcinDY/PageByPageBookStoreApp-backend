package com.inci.Page.by.Page.Book.Store.dataAccess.concretes;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
