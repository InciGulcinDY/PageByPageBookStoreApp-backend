package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.CategoryRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRule {
    private final CategoryRepository categoryRepository;
    private final MessageService messageService;

    public void existsCategoryByCategory (String category) {
        if (categoryRepository.existsCategoryByCategory(category)){
            throw new BusinessException(messageService.getMessage(Messages.Category.getCategoryAlreadyExistsMessage));
        }
    }

    public void existsCategoryById(int id) {
        if(!categoryRepository.existsById(id)){
            throw new BusinessException(messageService.getMessage(Messages.Category.getCategoryNotFoundMessages));
        }
    }

}
