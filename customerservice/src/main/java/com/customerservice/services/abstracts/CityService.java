package com.customerservice.services.abstracts;

import com.customerservice.entities.concretes.City;
import com.customerservice.services.dtos.requests.cities.CreateCityRequest;
import com.customerservice.services.dtos.responses.cities.CreateCityResponse;
import com.customerservice.services.dtos.responses.cities.GetListCityResponse;

import java.util.List;
import java.util.Optional;

public interface CityService {
    CreateCityResponse add(CreateCityRequest createCityRequest);
    List<GetListCityResponse> getList();
    Optional<City> getByName(String name);
}
