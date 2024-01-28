package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    //  Derived Query Methods
    boolean existsLanguageByLanguage(String language);

}
