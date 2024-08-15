package com.customerservice.services.mappers;

import com.customerservice.entities.concretes.City;
import com.customerservice.services.dtos.requests.cities.CreateCityRequest;
import com.customerservice.services.dtos.responses.cities.CreateCityResponse;
import com.customerservice.services.dtos.responses.cities.GetListCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreateCityResponse createCityResponseFromCity(City city);
    GetListCityResponse getListCityResponseFromCity(City city);
}
