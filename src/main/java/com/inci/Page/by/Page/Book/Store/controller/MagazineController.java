package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.MagazineService;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.AddMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.DeleteMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.UpdateMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetAllMagazineResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetMagazineByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazines")
@AllArgsConstructor
@CrossOrigin
public class MagazineController {

    private final MagazineService magazineService;

    @PostMapping
    public void add (@RequestBody @Valid AddMagazineRequest request) {
        magazineService.add(request);
    }

    @PutMapping
    public void update (@RequestBody @Valid UpdateMagazineRequest request) {
        magazineService.update(request);
    }

    @DeleteMapping
    public void delete (@RequestBody @Valid DeleteMagazineRequest request) {
        magazineService.delete(request);
    }

    @GetMapping
    public List<GetAllMagazineResponse> getAll() {
        return magazineService.getAll();
    }

    @GetMapping ("/{id}")
    public GetMagazineByIdResponse getById (@PathVariable int id) {
        return magazineService.getById(id);
    }

}
