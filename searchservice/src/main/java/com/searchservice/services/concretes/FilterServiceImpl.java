package com.searchservice.services.concretes;

import com.searchservice.entities.Customer;
import com.searchservice.repositories.CustomerRepository;
import com.searchservice.services.abstracts.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
         customerRepository.save(customer);

    }
}
