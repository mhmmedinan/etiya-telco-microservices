package com.customerservice.services.mappers;

import com.customerservice.entities.concretes.City;
import com.customerservice.entities.concretes.District;
import com.customerservice.services.dtos.requests.cities.CreateCityRequest;
import com.customerservice.services.dtos.requests.districts.CreateDistrictRequest;
import com.customerservice.services.dtos.responses.cities.CreateCityResponse;
import com.customerservice.services.dtos.responses.cities.GetListCityResponse;
import com.customerservice.services.dtos.responses.districts.CreateDistrictResponse;
import com.customerservice.services.dtos.responses.districts.GetListDistrictResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);


    //@Mapping(source = "cityId",target = "city.id")
    District districtFromCreateDistrictRequest(CreateDistrictRequest createDistrictRequest);


    //@Mapping(source = "city.id",target = "cityId")
    CreateDistrictResponse createDistrictResponseFromDistrict(District district);

    //@Mapping(source = "city.name",target = "cityName")
    GetListDistrictResponse getListDistrictResponseFromDistrict(District district);
}
