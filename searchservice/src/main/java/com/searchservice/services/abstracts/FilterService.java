package com.searchservice.services.abstracts;

import com.searchservice.entities.Customer;

import java.util.List;

public interface FilterService {

    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer getById(String id);
    List<Customer> getList();
    Customer getByFirstName(String firstName);

}
