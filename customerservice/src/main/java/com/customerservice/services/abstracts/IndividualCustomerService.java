package com.customerservice.services.abstracts;

import com.customerservice.services.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.customerservice.services.dtos.responses.individualCustomers.CreateIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.GetListIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    List<GetListIndividualCustomerResponse> getList();
}
