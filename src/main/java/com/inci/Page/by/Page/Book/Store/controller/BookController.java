package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.BookService;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.AddBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.DeleteBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.UpdateBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.response.GetAllBookResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.response.GetBookByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
@CrossOrigin
public class BookController {
    private final BookService bookService;

    @PostMapping
    public void add(@RequestBody @Valid AddBookRequest request){
        bookService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBookRequest request){
        bookService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteBookRequest request) {
        bookService.delete(request);
    }

    @GetMapping
    public List<GetAllBookResponse> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public GetBookByIdResponse getById (@PathVariable  int id) {
        return bookService.getById(id);
    }
}
