package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.CityRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.City;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CityService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.AddCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.DeleteCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.UpdateCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetCityByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.CityBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapperService modelMapperService;
    private final CityBusinessRule cityBusinessRule;
    private final MessageService messageService;

    @Override
    public Result add(AddCityRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setCity(request.getCity().toLowerCase());

        //  Business Rules
        cityBusinessRule.existsCityByCity(request.getCity());

        //  Mapping
        City city = modelMapperService.forRequest().map(request, City.class);

        //  Saving
        cityRepository.save(city);

        return new SuccessResult(Messages.City.cityAddSuccess);
    }

    @Override
    public Result update(UpdateCityRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setCity(request.getCity().toLowerCase());

        //  Business Rules
        cityRepository.existsCityByCity(request.getCity());

        //  Mapping
        City city = modelMapperService.forRequest().map(request, City.class);

        //  Saving
        cityRepository.save(city);

        return new SuccessResult(Messages.City.cityUpdateSuccess);
    }

    @Override
    public Result delete(DeleteCityRequest request) {
        //  Checking the existence
        cityBusinessRule.existsCityById(request.getId());

        //  Delete
        cityRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.City.cityDeleteSuccess));
    }

    @Override
    public List<GetAllCitiesResponse> getAll() {
        return cityRepository.getAll();
    }

    @Override
    public GetCityByIdResponse getById(int id) {
        //  Find the relevant id
        City city = cityRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.City.getCityNotFoundMessages)));

        //  Mapping
        return modelMapperService.forResponse().map(city, GetCityByIdResponse.class);
    }
}
