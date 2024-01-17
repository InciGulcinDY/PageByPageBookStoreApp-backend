package com.inci.Page.by.Page.Book.Store.dataAccess;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    //DERIVED QUERY METHODS:
    boolean existsLanguageByLanguage(String language);

}
