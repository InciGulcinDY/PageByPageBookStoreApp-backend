package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.CountryRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Country;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CountryService;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.AddCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.DeleteCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.UpdateCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetCountryByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddCountryRequest request) {

        //Converting to the uppercase characters to the lowercase
        request.setCountry(request.getCountry().toLowerCase());

        //Business Rules
        if (countryRepository.existsCountryByCountry(request.getCountry())){
            throw new RuntimeException("This country already exists!");
        }

        //Mapping
        Country country = modelMapperService.forRequest().map(request, Country.class);

        //Saving
        countryRepository.save(country);

    }

    @Override
    public void update(UpdateCountryRequest request) {

        //Converting to the uppercase characters to the lowercase
        request.setCountry(request.getCountry().toLowerCase());

        //Business Rules
        if (countryRepository.existsCountryByCountry(request.getCountry())){
            throw new RuntimeException("This country already exists!");
        }

        //Mapping
        Country country = modelMapperService.forRequest().map(request, Country.class);

        //Saving
        countryRepository.save(country);

    }

    @Override
    public void delete(DeleteCountryRequest request) {

        //Finding the country to be deleted
        countryRepository.findById(request.getId()).orElseThrow();

        //Delete
        countryRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllCountryResponse> getAll() {

        return countryRepository.getAll();

    }

    @Override
    public GetCountryByIdResponse getById(int id) {

        //Finding the relevant id
        Country country = countryRepository.findById(id).orElseThrow();

        //Mapping
        return modelMapperService.forResponse().map(country, GetCountryByIdResponse.class);

    }
}
