package com.customerservice.webapi.controllers;

import com.customerservice.entities.concretes.City;
import com.customerservice.services.abstracts.CityService;
import com.customerservice.services.dtos.requests.cities.CreateCityRequest;
import com.customerservice.services.dtos.responses.cities.CreateCityResponse;
import com.customerservice.services.dtos.responses.cities.GetListCityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cities")
@RequiredArgsConstructor
public class CitiesController
{
    private final CityService cityService;

    @PostMapping
    public CreateCityResponse add(@RequestBody CreateCityRequest createCityRequest)
    {
       return cityService.add(createCityRequest);
    }

    @GetMapping
    public List<GetListCityResponse> getList()
    {
        return cityService.getList();
    }

    @GetMapping("{name}")
    public Optional<City> getList(@PathVariable String name)
    {
        return cityService.getByName(name);
    }
}
