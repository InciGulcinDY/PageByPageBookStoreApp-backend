package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.AddCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.DeleteCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.UpdateCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetCityByIdResponse;

import java.util.List;

public interface CityService {
    void add(AddCityRequest request);
    void update(UpdateCityRequest request);
    void delete(DeleteCityRequest request);
    List<GetAllCitiesResponse> getAll();
    GetCityByIdResponse getCityById(int id);
}
