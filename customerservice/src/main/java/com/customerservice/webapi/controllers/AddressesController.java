package com.customerservice.webapi.controllers;

import com.customerservice.services.abstracts.AddressService;
import com.customerservice.services.dtos.requests.addresses.CreateAddressRequest;
import com.customerservice.services.dtos.responses.addresses.CreateAddressResponse;
import com.customerservice.services.dtos.responses.addresses.GetListAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
@RequiredArgsConstructor
public class AddressesController {
    private final AddressService addressService;

    @PostMapping
    public CreateAddressResponse add(@RequestBody CreateAddressRequest createAddressRequest)
    {
        return addressService.add(createAddressRequest);
    }

    @GetMapping
    public List<GetListAddressResponse> getList()
    {
        return addressService.getList();
    }
}
