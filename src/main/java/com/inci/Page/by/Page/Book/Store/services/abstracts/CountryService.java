package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.AddCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.DeleteCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.UpdateCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetCountryByIdResponse;

import java.util.List;

public interface CountryService {
    void add(AddCountryRequest request);
    void update(UpdateCountryRequest request);
    void delete(DeleteCountryRequest request);
    List<GetAllCountryResponse> getAll();
    GetCountryByIdResponse getById(int id);
}
