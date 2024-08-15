package com.customerservice.services.concretes;

import com.customerservice.entities.concretes.City;
import com.customerservice.entities.concretes.District;
import com.customerservice.repositories.DistrictRepository;
import com.customerservice.services.abstracts.DistrictService;
import com.customerservice.services.dtos.requests.districts.CreateDistrictRequest;
import com.customerservice.services.dtos.responses.districts.CreateDistrictResponse;
import com.customerservice.services.dtos.responses.districts.GetListDistrictResponse;
import com.customerservice.services.mappers.DistrictMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Override
    public CreateDistrictResponse add(CreateDistrictRequest createDistrictRequest) {
/*        City city = new City();
        city.setId(createDistrictRequest.getCityId());*/
        District mappedDistrict = DistrictMapper.INSTANCE.districtFromCreateDistrictRequest(createDistrictRequest);
/*        mappedDistrict.setCity(city);*/
        District createdDistrict =districtRepository.save(mappedDistrict);
        CreateDistrictResponse response = DistrictMapper.INSTANCE.createDistrictResponseFromDistrict(createdDistrict);
        return response;
    }

    @Override
    public List<GetListDistrictResponse> getList() {
        List<District> districts = districtRepository.findAll();
        List<GetListDistrictResponse> responses = districts.stream()
                .map(DistrictMapper.INSTANCE::getListDistrictResponseFromDistrict).collect(Collectors.toList());
        return responses;
    }
}
