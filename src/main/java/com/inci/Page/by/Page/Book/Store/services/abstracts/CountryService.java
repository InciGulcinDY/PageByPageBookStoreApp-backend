package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.AddCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.DeleteCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.UpdateCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetCountryByIdResponse;

import java.util.List;

public interface CountryService {
    Result add(AddCountryRequest request);
    Result update(UpdateCountryRequest request);
    Result delete(DeleteCountryRequest request);


    List<GetAllCountryResponse> getAll();
    GetCountryByIdResponse getById(int id);
}
