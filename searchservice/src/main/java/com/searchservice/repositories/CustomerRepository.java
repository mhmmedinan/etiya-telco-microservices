package com.searchservice.repositories;

import com.searchservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<Customer, UUID> {
    Customer findByFirstName(String firstName);

}
