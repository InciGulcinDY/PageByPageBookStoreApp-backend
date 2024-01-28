package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.AuthorRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Author;
import com.inci.Page.by.Page.Book.Store.services.abstracts.AuthorService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.AddAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.DeleteAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.UpdateAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByNameResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.AuthorBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapperService modelMapperService;
    private final AuthorBusinessRule authorBusinessRule;
    private MessageService messageService;


    @Override
    public Result add(AddAuthorRequest request) {

        //  Converting uppercase letters to lowercase letters
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //  Business Rule
        authorBusinessRule.existsAuthorByFullName(request.getName(), request.getSurname());

        //  Mapping
        Author author = modelMapperService.forRequest().map(request, Author.class);

        //  Saving
        authorRepository.save(author);

        return new SuccessResult(messageService.getMessage(Messages.Author.authorAddSuccess));

    }

    @Override
    public Result update(UpdateAuthorRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //  Business Rule
        authorBusinessRule.existsAuthorByFullName(request.getName(), request.getSurname());

        //  Mapping
        Author author = modelMapperService.forRequest().map(request, Author.class);

        //  Saving
        authorRepository.save(author);

        return new SuccessResult(messageService.getMessage(Messages.Author.authorUpdateSuccess));
    }

    @Override
    public Result delete(DeleteAuthorRequest request) {

        //  Checking the existence of the author
        authorBusinessRule.existsAuthorById(request.getId());

        //  Delete the author
        authorRepository.deleteById(request.getId());

        return new SuccessResult((messageService.getMessage(Messages.Author.authorDeleteSuccess)));

    }

    @Override
    public List<GetAllAuthorsResponse> getAll() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public List<GetAuthorByNameResponse> getByName(String name) {

        List<Author> authors;

        if (name.isBlank()) {
            // If the name is blank, get all authors
            authors = authorRepository.findAll();
        } else {
            // If the name is not blank, get authors whose names start with the specified name
            authors = authorRepository.findByNameStartingWith(name);
        }

        //  Mapping
        return authors.stream()
                .map(author -> modelMapperService.forResponse()
                        .map(author, GetAuthorByNameResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetAuthorByIdResponse getById(int id) {
        //  Finding the relevant id!
        Author author = authorRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Author.getAuthorNotFoundMessage)));

        //  Mapping
        return this.modelMapperService.forResponse().map(author, GetAuthorByIdResponse.class);
    }
}
