package com.inci.Page.by.Page.Book.Store.services.abstracts;


import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.AddBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.DeleteBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.UpdateBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.response.GetAllBookResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.response.GetBookByIdResponse;

import java.util.List;

public interface BookService {
    Result add(AddBookRequest request);
    Result update(UpdateBookRequest request);
    Result delete(DeleteBookRequest request);

    List<GetAllBookResponse> getAll();
    GetBookByIdResponse getById(int id);

}
