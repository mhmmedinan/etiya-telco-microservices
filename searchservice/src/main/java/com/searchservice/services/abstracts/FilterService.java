package com.searchservice.services.abstracts;

import com.searchservice.entities.Customer;

import java.util.List;

public interface FilterService {

    void addCustomer(Customer customer);
    List<Customer> getList();
    Customer getByFirstName(String firstName);
}
