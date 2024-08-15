package com.customerservice.services.abstracts;

import com.customerservice.services.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.customerservice.services.dtos.requests.individualCustomers.DeleteIndividualCustomerRequest;
import com.customerservice.services.dtos.responses.individualCustomers.CreateIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.DeleteIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.GetListIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    DeleteIndividualCustomerResponse delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);
    List<GetListIndividualCustomerResponse> getList();
}
