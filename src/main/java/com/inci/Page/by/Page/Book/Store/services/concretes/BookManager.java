package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Book;
import com.inci.Page.by.Page.Book.Store.repositories.BookRepository;
import com.inci.Page.by.Page.Book.Store.services.abstracts.BookService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.AddBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.DeleteBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.request.UpdateBookRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.response.GetAllBookResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.book.response.GetBookByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.BookBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;
    private final BookBusinessRule bookBusinessRule;
    private final MessageService messageService;

    @Override
    public Result add(AddBookRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setTitle(request.getTitle().toLowerCase());

        //  Business Rule
        bookBusinessRule.existsBookByTitle(request.getTitle());

        //  Mapping
        Book book = modelMapperService.forRequest().map(request, Book.class);

        //  Saving
        bookRepository.save(book);

        return new SuccessResult(messageService.getMessage(Messages.Book.bookAddSuccess));
    }

    @Override
    public Result update(UpdateBookRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setTitle(request.getTitle().toLowerCase());

        //  Business Rule
        bookBusinessRule.existsBookByTitle(request.getTitle());

        //  Mapping
        Book book = modelMapperService.forRequest().map(request, Book.class);

        //  Saving
        bookRepository.save(book);

        return new SuccessResult(messageService.getMessage(Messages.Book.bookUpdateSuccess));
    }

    @Override
    public Result delete(DeleteBookRequest request) {
        //  Check the existence of the book
        bookBusinessRule.existsBookById(request.getId());

        //  Deleting
        bookRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Book.bookDeleteSuccess));
    }

    @Override
    public List<GetAllBookResponse> getAll() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapperService.forResponse()
                        .map(book, GetAllBookResponse.class)).toList();
    }

    @Override
    public GetBookByIdResponse getById(int id) {
        //  Finding the relevant id!
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Book.getBookNotFoundMessage)));

        //  Mapping
        return modelMapperService.forResponse().map(book, GetBookByIdResponse.class);
    }
}
