package com.inci.Page.by.Page.Book.Store.controller.concretes;

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
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddAuthorRequest request){
        authorService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateAuthorRequest request){
        authorService.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteAuthorRequest request){
        authorService.delete(request);
    }

    @GetMapping
    public List<GetAllAuthorsResponse> getAll(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/name")
    public List<GetAuthorByNameResponse> getByName(@RequestParam String name){
        return authorService.getAuthorByName(name);
    }

    @GetMapping("/{id}")
    public GetAuthorByIdResponse getById(@RequestParam int id){
        return authorService.getAuthorById(id);
    }
}
