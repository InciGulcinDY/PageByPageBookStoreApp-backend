package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.AddPublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.DeletePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.UpdatePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetAllPublisherResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetPublisherByIdResponse;

import java.util.List;

public interface PublisherService {
    void add(AddPublisherRequest request);
    void update(UpdatePublisherRequest request);
    void delete(DeletePublisherRequest request);
    List<GetAllPublisherResponse> getAll();
    GetPublisherByIdResponse getById(int id);
}
