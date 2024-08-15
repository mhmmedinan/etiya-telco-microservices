package com.customerservice.services.concretes;

import com.customerservice.entities.concretes.City;
import com.customerservice.repositories.CityRepository;
import com.customerservice.services.abstracts.CityService;
import com.customerservice.services.dtos.requests.cities.CreateCityRequest;
import com.customerservice.services.dtos.responses.cities.CreateCityResponse;
import com.customerservice.services.dtos.responses.cities.GetListCityResponse;
import com.customerservice.services.mappers.CityMapper;
import com.customerservice.services.rules.CityBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityBusinessRules cityBusinessRules;

    @Override
    public CreateCityResponse add(CreateCityRequest createCityRequest)
    {

        //Manuel Mapping
      /*  City mappedCity = new City();
        mappedCity.setName(createCityRequest.getName());
        City createdCity = cityRepository.save(mappedCity);

        CreateCityResponse response = new CreateCityResponse();
        response.setName(createdCity.getName());
        response.setCreatedDate(createdCity.getCreatedDate());
        return response;*/

        //Auto Mapping
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(createCityRequest.getName().trim());
        City mappedCity = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createCity = cityRepository.save(mappedCity);
        CreateCityResponse createCityResponse = CityMapper.INSTANCE.createCityResponseFromCity(createCity);
        return createCityResponse;
    }

    @Override
    public Optional<City> getByName(String name) {
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);
        return city;
    }

    @Override
    public List<GetListCityResponse> getList() {
        //Manuel Mapping

       /* List<City> cities = cityRepository.findAll();
        List<GetListCityResponse> getListCityResponses = cities.stream().map(city->{
            GetListCityResponse getListCityResponse = new GetListCityResponse();
            getListCityResponse.setId(city.getId());
            getListCityResponse.setName(city.getName());
            getListCityResponse.setCreatedDate(city.getCreatedDate());
            return getListCityResponse;
        }).collect(Collectors.toList());
        return getListCityResponses;*/

        //Auto Mapping
        List<City> cities = cityRepository.findAll();
        List<GetListCityResponse> getListCityResponses =
                cities.stream().map(
                CityMapper.INSTANCE::getListCityResponseFromCity).collect(Collectors.toList());
        return getListCityResponses;
    }

}
