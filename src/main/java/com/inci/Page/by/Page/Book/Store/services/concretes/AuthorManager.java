package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.concretes.AuthorRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Author;
import com.inci.Page.by.Page.Book.Store.services.abstracts.AuthorService;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.AddAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.DeleteAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.UpdateAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public Author getById(int id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public void add(AddAuthorRequest request) {
        //Converting uppercase letters to lowercase letters
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //Business Rule
        if (authorRepository.existsAuthorByName(request.getName()) &&
                authorRepository.existsAuthorBySurname(request.getSurname())) {
            throw new RuntimeException("The same author cannot be registered twice!");
        }

        //Mapping
        Author author = modelMapperService.forRequest().map(request, Author.class);

        //Saving
        authorRepository.save(author);
    }

    @Override
    public void update(UpdateAuthorRequest request) {
        //Business Rule
        if (authorRepository.existsAuthorByName(request.getName()) &&
                authorRepository.existsAuthorBySurname(request.getSurname())) {
            throw new RuntimeException("The same author cannot be registered twice!");
        }

        //Converting uppercase letters to lowercase letters
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //Mapping
        Author author = modelMapperService.forRequest().map(request,Author.class);

        //Updating
        authorRepository.save(author);

    }

    @Override
    public void delete(DeleteAuthorRequest request) {

        //Checking the existance of the author
        authorRepository.findById(request.getId()).orElseThrow();

        //Delete the author
        authorRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllAuthorsResponse> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public List<GetAuthorByNameResponse> getAuthorByName(String name) {

        List<Author> authors;

        if (name.isBlank()) {
            // If the name is blank, get all authors
            authors = authorRepository.findAll();
        } else {
            // If the name is not blank, get authors whose names start with the specified name
            authors = authorRepository.findByNameStartingWith(name);
        }

        //Mapping
        return authors.stream()
                .map(author -> modelMapperService.forResponse().map(author, GetAuthorByNameResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetAuthorByIdResponse getAuthorById(int id) {
        //Finding the relevant id!
        Author author = authorRepository.findById(id).orElseThrow();

        //Mapping
        return this.modelMapperService.forResponse().map(author, GetAuthorByIdResponse.class);
    }
}
