package com.customerservice.webapi.controllers;

import com.customerservice.services.abstracts.DistrictService;
import com.customerservice.services.dtos.requests.districts.CreateDistrictRequest;
import com.customerservice.services.dtos.responses.districts.CreateDistrictResponse;
import com.customerservice.services.dtos.responses.districts.GetListDistrictResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/districts")
@RequiredArgsConstructor
public class DistrictsController {

    private final DistrictService districtService;

    @PostMapping
    public CreateDistrictResponse add(@RequestBody CreateDistrictRequest createDistrictRequest)
    {
        return districtService.add(createDistrictRequest);
    }

    @GetMapping
    public List<GetListDistrictResponse> getList()
    {
        return districtService.getList();
    }
}
