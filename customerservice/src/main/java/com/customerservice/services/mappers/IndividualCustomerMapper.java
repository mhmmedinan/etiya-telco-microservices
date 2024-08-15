package com.customerservice.services.mappers;

import com.customerservice.entities.concretes.Address;
import com.customerservice.entities.concretes.IndividualCustomer;
import com.customerservice.services.dtos.requests.addresses.CreateAddressRequest;
import com.customerservice.services.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.customerservice.services.dtos.responses.addresses.CreateAddressResponse;
import com.customerservice.services.dtos.responses.addresses.GetListAddressResponse;
import com.customerservice.services.dtos.responses.individualCustomers.CreateIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.DeleteIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.GetListIndividualCustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IndividualCustomerMapper {
    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    //@Mapping(source = "gender",target = "gender")
    IndividualCustomer individualCustomerFromCreateIndividualCustomerRequest(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    CreateIndividualCustomerResponse createIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
    GetListIndividualCustomerResponse getListIndividualCustomerResponsesFromIndividualCustomer(IndividualCustomer individualCustomer);
    DeleteIndividualCustomerResponse deleteIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
}
