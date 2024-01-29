package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.AuthorService;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.AddAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.DeleteAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.request.UpdateAuthorRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAllAuthorsResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByNameResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/authors")
@AllArgsConstructor
@CrossOrigin
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public void add(@RequestBody @Valid AddAuthorRequest request){
        authorService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAuthorRequest request){
        authorService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteAuthorRequest request){
        authorService.delete(request);
    }

    @GetMapping
    public List<GetAllAuthorsResponse> getAll(){
        return authorService.getAll();
    }

    @GetMapping("/name")
    public List<GetAuthorByNameResponse> getByName(@RequestParam String name){
        return authorService.getByName(name);
    }

    @GetMapping("/{id}")
    public GetAuthorByIdResponse getById(@PathVariable int id){
        return authorService.getById(id);
    }
}
