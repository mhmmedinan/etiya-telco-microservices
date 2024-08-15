package com.customerservice.services.rules;


import com.customerservice.core.exceptions.types.BusinessException;
import com.customerservice.core.localization.abstraction.TranslationService;
import com.customerservice.entities.concretes.City;
import com.customerservice.repositories.CityRepository;
import com.customerservice.services.messages.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityBusinessRules {

    private final CityRepository cityRepository;
    private final TranslationService translationService;

    public void cityNameCanNotBeDuplicatedWhenInserted(String name)
    {
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);
        if (city.isPresent())
        {
            throw new BusinessException(translationService.getMessage(Messages.BusinessErrors.CityNameExists));
        }
    }
}
