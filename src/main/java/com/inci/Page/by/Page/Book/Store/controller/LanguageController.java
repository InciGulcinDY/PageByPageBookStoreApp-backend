package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.LanguageService;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.AddLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.DeleteLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.UpdateLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetAllLanguageResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetLanguageByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
@AllArgsConstructor
@CrossOrigin
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    public void add(@RequestBody @Valid AddLanguageRequest request){
        languageService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateLanguageRequest request){
        languageService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteLanguageRequest request){
        languageService.delete(request);
    }

    @GetMapping
    List<GetAllLanguageResponse> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    GetLanguageByIdResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

}
