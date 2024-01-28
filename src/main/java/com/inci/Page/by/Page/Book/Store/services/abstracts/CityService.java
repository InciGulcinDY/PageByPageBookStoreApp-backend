package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.AddCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.DeleteCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.UpdateCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetCityByIdResponse;

import java.util.List;

public interface CityService {
    Result add(AddCityRequest request);
    Result update(UpdateCityRequest request);
    Result delete(DeleteCityRequest request);


    List<GetAllCitiesResponse> getAll();
    GetCityByIdResponse getById(int id);
}
