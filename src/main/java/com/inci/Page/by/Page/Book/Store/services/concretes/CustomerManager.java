package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.concretes.CustomerRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Customer;
import com.inci.Page.by.Page.Book.Store.services.abstracts.CustomerService;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.AddCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.DeleteCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.UpdateCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetAllCustomerResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetCustomerByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddCustomerRequest request) {
        //Converting uppercase characters to lowercase
        request.setAddress(request.getAddress().toLowerCase());
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //Business Rules
        //Check the entered city in the db
        if(customerRepository.existsCustomerByCityId(request.getCityId())){
            throw new RuntimeException("The entered city is invalid!");
        }
        //Check the entered email in the db
        if(customerRepository.existsCustomerByEmail(request.getEmail())){
            throw new RuntimeException("The email entered is already registered!");
        }

        //Maping
        Customer customer = modelMapperService.forRequest().map(request, Customer.class);

        //Saving
        customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest request) {
        //Converting uppercase characters to lowercase
        request.setAddress(request.getAddress().toLowerCase());
        request.setName(request.getName().toLowerCase());
        request.setSurname(request.getSurname().toLowerCase());

        //Business Rules
        //Check the entered city in the db
        if(customerRepository.existsCustomerByCityId(request.getCityId())){
            throw new RuntimeException("The entered city is invalid!");
        }
        //Check the entered email in the db
        if(customerRepository.existsCustomerByEmail(request.getEmail())){
            throw new RuntimeException("The email entered is already registered!");
        }

        //Maping
        Customer customer = modelMapperService.forRequest().map(request, Customer.class);

        //Saving
        customerRepository.save(customer);

    }

    @Override
    public void delete(DeleteCustomerRequest request) {

    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        return null;
    }

    @Override
    public GetCustomerByIdResponse getById(int id) {
        return null;
    }
}
