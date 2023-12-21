package com.inci.Page.by.Page.Book.Store.controller.concretes;

import com.inci.Page.by.Page.Book.Store.services.abstracts.CityService;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.AddCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.DeleteCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.request.UpdateCityRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetCityByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public void add(@RequestBody @Valid AddCityRequest request){
        cityService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCityRequest request){
        cityService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteCityRequest request){
        cityService.delete(request);
    }

    @GetMapping
    public List<GetAllCitiesResponse> getAll(){
        return cityService.getAll();
    }

    @GetMapping({"id"})
    public GetCityByIdResponse getById(@RequestParam int id){
        return cityService.getCityById(id);
    }
}
