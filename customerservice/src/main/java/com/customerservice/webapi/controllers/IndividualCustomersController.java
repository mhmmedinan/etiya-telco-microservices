package com.customerservice.webapi.controllers;

import com.customerservice.services.abstracts.IndividualCustomerService;
import com.customerservice.services.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.customerservice.services.dtos.requests.individualCustomers.DeleteIndividualCustomerRequest;
import com.customerservice.services.dtos.responses.individualCustomers.CreateIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.DeleteIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.GetListIndividualCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/individualCustomers")
@RequiredArgsConstructor
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    public CreateIndividualCustomerResponse add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest)
    {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @GetMapping
    @Secured(value = {"customer.getlist"})
    public List<GetListIndividualCustomerResponse> getList()
    {
        return individualCustomerService.getList();
    }


    @DeleteMapping("{id}")
    public DeleteIndividualCustomerResponse add(@PathVariable UUID id)
    {
        DeleteIndividualCustomerRequest deleteIndividualCustomerRequest = new DeleteIndividualCustomerRequest();
        deleteIndividualCustomerRequest.setId(id);
        return individualCustomerService.delete(deleteIndividualCustomerRequest);
    }
}
