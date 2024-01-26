package com.inci.Page.by.Page.Book.Store.controller;

import com.inci.Page.by.Page.Book.Store.services.abstracts.CustomerService;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.AddCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.DeleteCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.request.UpdateCustomerRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetAllCustomerResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.customer.response.GetCustomerByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void add(@RequestBody @Valid AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomerRequest request){
        customerService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid DeleteCustomerRequest request){
        customerService.delete(request);
    }

    @GetMapping
    List<GetAllCustomerResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    GetCustomerByIdResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }
}
