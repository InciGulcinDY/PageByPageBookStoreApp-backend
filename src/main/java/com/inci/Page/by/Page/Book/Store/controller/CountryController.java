package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.CountryService;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.AddCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.DeleteCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.request.UpdateCountryRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetCountryByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@AllArgsConstructor
@CrossOrigin
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public void add(@RequestBody @Valid AddCountryRequest request){
        countryService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCountryRequest request){
        countryService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteCountryRequest request){
        countryService.delete(request);
    }

    @GetMapping
    public List<GetAllCountryResponse> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public GetCountryByIdResponse getById(@PathVariable int id){
        return countryService.getById(id);
    }

}
