package com.customerservice.webapi.controllers;

import com.customerservice.services.abstracts.IndividualCustomerService;
import com.customerservice.services.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.customerservice.services.dtos.responses.individualCustomers.CreateIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.GetListIndividualCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GetListIndividualCustomerResponse> getList()
    {
        return individualCustomerService.getList();
    }
}
