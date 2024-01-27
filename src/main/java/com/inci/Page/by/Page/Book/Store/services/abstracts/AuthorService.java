package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Author;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.AddAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.DeleteAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.UpdateAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByNameResponse;

import java.util.List;

public interface AuthorService {
    Result add(AddAuthorRequest request);
    Result update(UpdateAuthorRequest request);
    Result delete(DeleteAuthorRequest request);


    List<GetAllAuthorsResponse> getAll();
    List<GetAuthorByNameResponse> getByName(String name);
    GetAuthorByIdResponse getById(int id);



}
