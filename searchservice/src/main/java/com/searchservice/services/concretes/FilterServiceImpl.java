package com.searchservice.services.concretes;

import com.searchservice.entities.Customer;
import com.searchservice.repositories.CustomerRepository;
import com.searchservice.services.abstracts.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
         customerRepository.save(customer);

    }

    @Override
    public List<Customer> getList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }
}
