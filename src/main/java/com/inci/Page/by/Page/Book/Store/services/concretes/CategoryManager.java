package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.concretes.CategoryRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Category;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CategoryService;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.AddCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.DeleteCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.UpdateCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetAllCategoryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetCategoryByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public void add(AddCategoryRequest request) {
        //Converting uppercase letters to lowercase letters
        request.setCategory(request.getCategory().toLowerCase());

        //Business Rules
        if (categoryRepository.existsCategoryByCategory(request.getCategory())){
            throw new RuntimeException();
        }

        //Mapping
        Category category = modelMapperService.forRequest().map(request, Category.class);

        //Saving
        categoryRepository.save(category);

    }

    @Override
    public void update(UpdateCategoryRequest request) {
        //Converting uppercase letters to lowercase letters
        request.setCategory(request.getCategory().toLowerCase());

        //Business Rules
        if (categoryRepository.existsCategoryByCategory(request.getCategory())){
            throw new RuntimeException();
        }

        //Mapping
        Category category = modelMapperService.forRequest().map(request, Category.class);

        //Saving
        categoryRepository.save(category);

    }

    @Override
    public void delete(DeleteCategoryRequest request) {
        //Checking the existance of the category
        categoryRepository.findById(request.getId()).orElseThrow();

        //Delete the category
        categoryRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllCategoryResponse> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public GetCategoryByIdResponse getCategoryById(int id) {
        //Finding the relevant id!
        Category category = categoryRepository.findById(id).orElseThrow();

        //Mapping
        return modelMapperService.forResponse().map(category, GetCategoryByIdResponse.class);
    }
}
