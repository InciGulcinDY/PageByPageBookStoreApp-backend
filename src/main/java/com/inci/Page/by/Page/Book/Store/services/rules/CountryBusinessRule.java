package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.CountryRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryBusinessRule {
    private final CountryRepository countryRepository;
    private final MessageService messageService;

    public void existsCountryByCountry (String country) {
        if(countryRepository.existsCountryByCountry(country)) {
            throw new BusinessException(messageService.getMessage(Messages.Country.getCountryAlreadyExistsMessage));
        }
    }

    public void existsCountryById (int id) {
        if(!countryRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Country.getCountryNotFoundMessage));
        }
    }
}
