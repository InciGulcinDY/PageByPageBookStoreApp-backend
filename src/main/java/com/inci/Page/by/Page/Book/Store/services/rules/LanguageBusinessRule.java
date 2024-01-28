package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.LanguageRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageBusinessRule {
    private final LanguageRepository languageRepository;
    private final MessageService messageService;

    public void existsLanguageByLanguage (String language) {
        if(languageRepository.existsLanguageByLanguage(language)) {
            throw new BusinessException(messageService.getMessage(Messages.Language.getLanguageAlreadyExistsMessage));
        }
    }

    public void existsLanguageById (int id) {
        if (!languageRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Language.getLanguageNotFoundMessage));
        }
    }
}
