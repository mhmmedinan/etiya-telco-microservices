package com.customerservice.services.abstracts;

import com.customerservice.services.dtos.requests.addresses.CreateAddressRequest;
import com.customerservice.services.dtos.responses.addresses.CreateAddressResponse;
import com.customerservice.services.dtos.responses.addresses.GetListAddressResponse;

import java.util.List;

public interface AddressService {
    CreateAddressResponse add(CreateAddressRequest createAddressRequest);
    List<GetListAddressResponse> getList();
}
