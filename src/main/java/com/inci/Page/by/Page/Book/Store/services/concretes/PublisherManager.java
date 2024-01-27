package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.PublisherRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Publisher;
import com.inci.Page.by.Page.Book.Store.services.abstracts.PublisherService;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.AddPublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.DeletePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.UpdatePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetAllPublisherResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetPublisherByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherManager implements PublisherService {

    private final ModelMapperService modelMapperService;
    private final PublisherRepository publisherRepository;

    @Override
    public void add(AddPublisherRequest request) {

        //  Converting uppercase letters to lowercase letters
        request.setPublisher(request.getPublisher().toLowerCase());

        //  Business Rules
        if(publisherRepository.existsPublisherByPublisher(request.getPublisher())){
            throw new RuntimeException();
        }

        //  Mapping
        Publisher publisher = modelMapperService.forRequest().map(request, Publisher.class);

        //  Saving
        publisherRepository.save(publisher);

    }

    @Override
    public void update(UpdatePublisherRequest request) {

        //  Converting uppercase letters to lowercase letters
        request.setPublisher(request.getPublisher().toLowerCase());

        //  Business Rules
        if(publisherRepository.existsPublisherByPublisher(request.getPublisher())){
            throw new RuntimeException();
        }

        //  Mapping
        Publisher publisher = modelMapperService.forRequest().map(request, Publisher.class);

        //  Updating
        publisherRepository.save(publisher);

    }

    @Override
    public void delete(DeletePublisherRequest request) {

        //  Checking the existence of the publisher
        publisherRepository.findById(request.getId()).orElseThrow();

        //Delete the publisher
        publisherRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllPublisherResponse> getAll() {

        return publisherRepository.findAll().stream()
                .map(publisher -> modelMapperService.forResponse()
                        .map(publisher, GetAllPublisherResponse.class)).toList();

    }

    @Override
    public GetPublisherByIdResponse getById(int id) {
        //  Finding the relevant id!
        Publisher publisher = publisherRepository.findById(id).orElseThrow();

        //  Mapping
        return modelMapperService.forResponse().map(publisher,GetPublisherByIdResponse.class);

    }
}
