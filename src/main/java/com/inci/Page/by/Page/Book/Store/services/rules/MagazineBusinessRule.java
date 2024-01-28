package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.MagazineRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MagazineBusinessRule {
    private final MagazineRepository magazineRepository;
    private final MessageService messageService;

    public void existsMagazineByTitle (String title) {
        if (magazineRepository.existsMagazineByTitle(title)) {
            throw new BusinessException(messageService.getMessage(Messages.Magazine.getMagazineAlreadyExistsMessage));
        }
    }

    public void existsMagazineById (int id) {
        if (!magazineRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Magazine.getMagazineNotFoundMessage));
        }
    }
}
