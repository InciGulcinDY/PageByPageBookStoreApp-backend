package com.inci.Page.by.Page.Book.Store.services.rules;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.BusinessException;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.repositories.CityRepository;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityBusinessRule {
    private final CityRepository cityRepository;
    private final MessageService messageService;

    public void existsCityByCity (String city) {
        if(cityRepository.existsCityByCity(city)) {
            throw new BusinessException(messageService.getMessage(Messages.City.getCityAlreadyExistsMessage));
        }
    }

    public void existsCityById(int id) {
        if(!cityRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.City.getCityNotFoundMessages));
        }
    }
}
