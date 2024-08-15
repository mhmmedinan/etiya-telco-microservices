package com.customerservice.services.mappers;

import com.customerservice.entities.concretes.Address;
import com.customerservice.services.dtos.requests.addresses.CreateAddressRequest;
import com.customerservice.services.dtos.responses.addresses.CreateAddressResponse;
import com.customerservice.services.dtos.responses.addresses.GetListAddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    //@Mapping(source = "customerId",target = "customer.id")
    //@Mapping(source = "districtId",target = "district.id")
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);

    //@Mapping(source = "customer.id",target = "customerId")
    //@Mapping(source = "district.id",target = "districtId")
    CreateAddressResponse createAddressResponseFromAddress(Address address);


    //@Mapping(source = "district.name",target = "districtName")
    //@Mapping(source = "district.city.name",target = "cityName")
    GetListAddressResponse getListAddressResponsesFromAddresses(Address address);
}
