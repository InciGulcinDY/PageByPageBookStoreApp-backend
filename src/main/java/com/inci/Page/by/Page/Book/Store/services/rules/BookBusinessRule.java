package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.BookRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookBusinessRule {
    private final BookRepository bookRepository;
    private final MessageService messageService;

    public void existsBookByTitle (String title) {
        if (bookRepository.existsBookByTitle(title)) {
            throw new BusinessException(messageService.getMessage(Messages.Book.getBookTitleAlreadyExitsMessage));
        }
    }

    public void existsBookById (int id) {
        if (!bookRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Book.getBookNotFoundMessage));
        }
    }
}
