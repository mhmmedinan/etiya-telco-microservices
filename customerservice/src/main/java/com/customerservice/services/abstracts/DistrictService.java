package com.customerservice.services.abstracts;

import com.customerservice.services.dtos.requests.districts.CreateDistrictRequest;
import com.customerservice.services.dtos.responses.districts.CreateDistrictResponse;
import com.customerservice.services.dtos.responses.districts.GetListDistrictResponse;

import java.util.List;

public interface DistrictService {
    CreateDistrictResponse add(CreateDistrictRequest createDistrictRequest);
    List<GetListDistrictResponse> getList();
}
