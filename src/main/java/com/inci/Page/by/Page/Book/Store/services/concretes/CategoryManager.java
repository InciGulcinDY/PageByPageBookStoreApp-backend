package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.CategoryRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Category;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CategoryService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.AddCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.DeleteCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.UpdateCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetAllCategoryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetCategoryByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.CategoryBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;
    private final CategoryBusinessRule categoryBusinessRule;
    private final MessageService messageService;


    @Override
    public Result add(AddCategoryRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setCategory(request.getCategory().toLowerCase());

        //  Business Rules
        categoryBusinessRule.existsCategoryByCategory(request.getCategory());

        //  Mapping
        Category category = modelMapperService.forRequest().map(request, Category.class);

        //  Saving
        categoryRepository.save(category);

        return new SuccessResult(messageService.getMessage(Messages.Category.categoryAddSuccess));
    }

    @Override
    public Result update(UpdateCategoryRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setCategory(request.getCategory().toLowerCase());

        //  Business Rules
        categoryBusinessRule.existsCategoryByCategory(request.getCategory());

        //  Mapping
        Category category = modelMapperService.forRequest().map(request, Category.class);

        //  Saving
        categoryRepository.save(category);

        return new SuccessResult(messageService.getMessage(Messages.Category.categoryUpdateSuccess));

    }

    @Override
    public Result delete(DeleteCategoryRequest request) {

        //  Checking the existence of the category
        categoryBusinessRule.existsCategoryById(request.getId());

        //  Delete the category
        categoryRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Category.categoryDeleteSuccess));

    }

    @Override
    public List<GetAllCategoryResponse> getAll() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public GetCategoryByIdResponse getById(int id) {

        //  Finding the relevant id!
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Category.getCategoryNotFoundMessages)));

        //  Mapping
        return modelMapperService.forResponse().map(category, GetCategoryByIdResponse.class);
    }
}
