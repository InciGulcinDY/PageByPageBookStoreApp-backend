package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.PublisherService;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.AddPublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.DeletePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.UpdatePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetAllPublisherResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetPublisherByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@AllArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public void add(AddPublisherRequest request){
        publisherService.add(request);
    }

    @PutMapping
    public void update (UpdatePublisherRequest request) {
        publisherService.update(request);
    }

    @DeleteMapping
    public void delete(DeletePublisherRequest request) {
        publisherService.delete(request);
    }

    @GetMapping
    public List<GetAllPublisherResponse> getAll(){
        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    public GetPublisherByIdResponse getById(int id){
        return publisherService.getById(id);
    }

}
