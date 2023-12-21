package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.concretes.CityRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.City;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CityService;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.AddCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.DeleteCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.UpdateCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetCityByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddCityRequest request) {
        //Converting uppercase letters to lowercase letters
        request.setCity(request.getCity().toLowerCase());

        //Business Rules
        if (cityRepository.existsCityByCity(request.getCity())){
            throw new RuntimeException("City already exists!");
        }

        //Mapping
        City city = modelMapperService.forRequest().map(request, City.class);

        //Saving
        cityRepository.save(city);
    }

    @Override
    public void update(UpdateCityRequest request) {
        //Converting uppercase letters to lowercase letters
        request.setCity(request.getCity().toLowerCase());

        //Business Rules
        if (cityRepository.existsCityByCity(request.getCity())){
            throw new RuntimeException();
        }

        //Mapping
        City city = modelMapperService.forRequest().map(request, City.class);

        //Saving
        cityRepository.save(city);
    }

    @Override
    public void delete(DeleteCityRequest request) {
        //Check the category id to be deleted
        cityRepository.findById(request.getId()).orElseThrow();

        //Delete the relevant category
        cityRepository.deleteById(request.getId());
    }

    @Override
    public List<GetAllCitiesResponse> getAll() {
        return cityRepository.getAll();
    }

    @Override
    public GetCityByIdResponse getCityById(int id) {
        //Find the relevant id
        City city = cityRepository.findById(id).orElseThrow();

        //Mapping
        return modelMapperService.forResponse().map(city, GetCityByIdResponse.class);
    }
}
