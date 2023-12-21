package com.inci.Page.by.Page.Book.Store.dataAccess.concretes;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Author;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // Derived Query Methods
    boolean existsAuthorByName(String name);
    boolean existsAuthorBySurname(String surname);
    List<Author> findByNameStartingWith(String name);


    //JPQL Methods
    @Query("select new com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse" +
            "(a.name, a.surname) " +
            "from Author a")
    List<GetAllAuthorsResponse> getAllAuthors();
}
