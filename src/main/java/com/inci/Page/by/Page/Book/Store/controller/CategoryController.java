package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.CategoryService;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.AddCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.DeleteCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.request.UpdateCategoryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetAllCategoryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetCategoryByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@CrossOrigin
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public void add(@RequestBody @Valid AddCategoryRequest request){
        categoryService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCategoryRequest request){
        categoryService.update(request);
    }
    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteCategoryRequest request){
        categoryService.delete(request);
    }

    @GetMapping
    public List<GetAllCategoryResponse> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryByIdResponse getById(@PathVariable int id){
        return categoryService.getById(id);
    }
}
