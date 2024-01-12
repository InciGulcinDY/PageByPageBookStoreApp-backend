package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.AddCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.DeleteCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.UpdateCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetAllCustomerResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetCustomerByIdResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    List<GetAllCustomerResponse> getAll();
    GetCustomerByIdResponse getById(int id);
}
