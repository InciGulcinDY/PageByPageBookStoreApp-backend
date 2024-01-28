package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.CountryRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Country;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CountryService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.AddCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.DeleteCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.UpdateCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetCountryByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.CountryBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapperService modelMapperService;
    private final CountryBusinessRule countryBusinessRule;
    private final MessageService messageService;
    @Override
    public Result add(AddCountryRequest request) {
        //  Converting to the uppercase characters to the lowercase
        request.setCountry(request.getCountry().toLowerCase());

        //  Business Rules
        countryBusinessRule.existsCountryByCountry(request.getCountry());

        //  Mapping
        Country country = modelMapperService.forRequest().map(request, Country.class);

        //  Saving
        countryRepository.save(country);

        return new SuccessResult(messageService.getMessage(Messages.Country.countryAddSuccess));
    }

    @Override
    public Result update(UpdateCountryRequest request) {
        //  Converting to the uppercase characters to the lowercase
        request.setCountry(request.getCountry().toLowerCase());

        //  Business Rules
        countryBusinessRule.existsCountryByCountry(request.getCountry());

        //  Mapping
        Country country = modelMapperService.forRequest().map(request, Country.class);

        //  Saving
        countryRepository.save(country);

        return new SuccessResult(messageService.getMessage(Messages.Country.countryUpdateSuccess));

    }

    @Override
    public Result delete(DeleteCountryRequest request) {
        //  Finding the country to be deleted
        countryBusinessRule.existsCountryById(request.getId());

        //  Delete
        countryRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Country.countryDeleteSuccess));
    }

    @Override
    public List<GetAllCountryResponse> getAll() {
        return countryRepository.getAll();
    }

    @Override
    public GetCountryByIdResponse getById(int id) {
        //  Finding the relevant id
        Country country = countryRepository.findById(id).orElseThrow(() ->
                new NotFoundException(Messages.Country.getCountryNotFoundMessage));

        //  Mapping
        return modelMapperService.forResponse().map(country, GetCountryByIdResponse.class);
    }
}
