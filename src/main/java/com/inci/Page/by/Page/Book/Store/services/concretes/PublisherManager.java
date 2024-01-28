package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.PublisherRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Publisher;
import com.inci.Page.by.Page.Book.Store.services.abstracts.PublisherService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.AddPublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.DeletePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request.UpdatePublisherRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetAllPublisherResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetPublisherByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.PublisherBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherManager implements PublisherService {

    private final ModelMapperService modelMapperService;
    private final PublisherRepository publisherRepository;
    private final PublisherBusinessRule publisherBusinessRule;
    private final MessageService messageService;

    @Override
    public Result add(AddPublisherRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setPublisher(request.getPublisher().toLowerCase());

        //  Business Rules
        publisherBusinessRule.existsPublisherByPublisher(request.getPublisher());

        //  Mapping
        Publisher publisher = modelMapperService.forRequest().map(request, Publisher.class);

        //  Saving
        publisherRepository.save(publisher);

        return new SuccessResult(messageService.getMessage(Messages.Publisher.publisherAddSuccess));
    }

    @Override
    public Result update(UpdatePublisherRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setPublisher(request.getPublisher().toLowerCase());

        //  Business Rules
        publisherBusinessRule.existsPublisherByPublisher(request.getPublisher());

        //  Mapping
        Publisher publisher = modelMapperService.forRequest().map(request, Publisher.class);

        //  Saving
        publisherRepository.save(publisher);

        return new SuccessResult(messageService.getMessage(Messages.Publisher.publisherUpdateSuccess));
    }

    @Override
    public Result delete(DeletePublisherRequest request) {

        //  Checking the existence of the publisher
        publisherBusinessRule.existsPublisherId(request.getId());

        //Deleting the publisher
        publisherRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Publisher.publisherDeleteSuccess));
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
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Publisher.getPublisherNotFoundMessage)));

        //  Mapping
        return modelMapperService.forResponse().map(publisher,GetPublisherByIdResponse.class);
    }
}
