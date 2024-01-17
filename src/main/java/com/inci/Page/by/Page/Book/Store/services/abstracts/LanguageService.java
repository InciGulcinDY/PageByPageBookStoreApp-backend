package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.AddLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.DeleteLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.UpdateLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetAllLanguageResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetLanguageByIdResponse;

import java.util.List;

public interface LanguageService {

    void add(AddLanguageRequest request);
    void update(UpdateLanguageRequest request);
    void delete(DeleteLanguageRequest request);
    List<GetAllLanguageResponse> getAll();
    GetLanguageByIdResponse getById(int id);

}
