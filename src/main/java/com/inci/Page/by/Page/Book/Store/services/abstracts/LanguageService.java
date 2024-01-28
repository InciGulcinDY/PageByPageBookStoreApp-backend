package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.AddLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.DeleteLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.UpdateLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetAllLanguageResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetLanguageByIdResponse;

import java.util.List;

public interface LanguageService {

    Result add(AddLanguageRequest request);
    Result update(UpdateLanguageRequest request);
    Result delete(DeleteLanguageRequest request);


    List<GetAllLanguageResponse> getAll();
    GetLanguageByIdResponse getById(int id);

}
