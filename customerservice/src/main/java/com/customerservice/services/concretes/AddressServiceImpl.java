package com.customerservice.services.concretes;

import com.customerservice.entities.concretes.Address;
import com.customerservice.repositories.AddressRepository;
import com.customerservice.services.abstracts.AddressService;
import com.customerservice.services.dtos.requests.addresses.CreateAddressRequest;
import com.customerservice.services.dtos.responses.addresses.CreateAddressResponse;
import com.customerservice.services.dtos.responses.addresses.GetListAddressResponse;
import com.customerservice.services.mappers.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public CreateAddressResponse add(CreateAddressRequest createAddressRequest) {
        Address mappedAddress = AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        Address createdAddress = addressRepository.save(mappedAddress);
        CreateAddressResponse response = AddressMapper.INSTANCE.createAddressResponseFromAddress(createdAddress);
        return response;
    }

    @Override
    public List<GetListAddressResponse> getList() {
        List<Address> addresses = addressRepository.findAll();
        List<GetListAddressResponse> responses = addresses.stream()
                .map(AddressMapper.INSTANCE::getListAddressResponsesFromAddresses).collect(Collectors.toList());
        return responses;
    }
}
