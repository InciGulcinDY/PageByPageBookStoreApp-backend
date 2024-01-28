package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Category;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.AddCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.DeleteCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.UpdateCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetAllCategoryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetCategoryByIdResponse;

import java.util.List;

public interface CategoryService {

    Result add(AddCategoryRequest request);
    Result update(UpdateCategoryRequest request);
    Result delete(DeleteCategoryRequest request);


    List<GetAllCategoryResponse> getAll();
    GetCategoryByIdResponse getById(int id);

}
