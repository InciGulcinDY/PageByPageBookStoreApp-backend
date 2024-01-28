package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.PublisherRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublisherBusinessRule {
    private final PublisherRepository publisherRepository;
    private final MessageService messageService;

    public void existsPublisherByPublisher (String publisher) {
        if (publisherRepository.existsPublisherByPublisher(publisher)) {
            throw new BusinessException(messageService.getMessage(Messages.Publisher.getPublisherAlreadyExistsMessage));
        }
    }

    public void existsPublisherId (int id) {
        if(!publisherRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Publisher.getPublisherNotFoundMessage));
        }
    }
}
