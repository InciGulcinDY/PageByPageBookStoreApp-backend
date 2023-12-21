package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Author;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.AddAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.DeleteAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.UpdateAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByNameResponse;

import java.util.List;

public interface AuthorService {
    Author getById(int id);
    void add(AddAuthorRequest request);
    void update(UpdateAuthorRequest request);
    void delete(DeleteAuthorRequest request);
    List<GetAllAuthorsResponse> getAllAuthors();
    List<GetAuthorByNameResponse> getAuthorByName(String name);
    GetAuthorByIdResponse getAuthorById(int id);



}
