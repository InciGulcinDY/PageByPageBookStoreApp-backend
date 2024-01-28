package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.AuthorRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorBusinessRule {
    private final AuthorRepository authorRepository;
    private final MessageService messageService;

    public void existsAuthorByFullName (String name, String surname) {
        if (authorRepository.existsAuthorByName(name) &&
                authorRepository.existsAuthorBySurname(surname))
            throw new BusinessException(messageService.getMessage(Messages.Author.getAuthorFullNameAlreadyExitsMessage));
    }

    public void existsAuthorById (int id) {
        if (!authorRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Author.getAuthorNotFoundMessage));
        }
    }

}
