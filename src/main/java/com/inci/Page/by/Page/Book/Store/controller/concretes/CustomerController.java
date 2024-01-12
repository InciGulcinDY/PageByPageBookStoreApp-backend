package com.inci.Page.by.Page.Book.Store.controller.concretes;

import com.inci.Page.by.Page.Book.Store.services.abstracts.CustomerService;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.AddCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.DeleteCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.UpdateCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetAllCustomerResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetCustomerByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void add(AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping
    public void update(UpdateCustomerRequest request){
        customerService.update(request);
    }

    @DeleteMapping
    public void delete(DeleteCustomerRequest request){
        customerService.delete(request);
    }

    @GetMapping
    List<GetAllCustomerResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping({"id"})
    GetCustomerByIdResponse getById(int id){
        return customerService.getById(id);
    }
}
