package com.searchservice.kafka.consumers.customers;

import com.etiya.common.events.customers.CreatedIndividualCustomerEvent;
import com.searchservice.entities.Customer;
import com.searchservice.services.abstracts.FilterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateIndividualCustomerConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateIndividualCustomerConsumer.class);
    private final FilterService filterService;

    @KafkaListener(topics = "customer-created",groupId ="created-customer")
    private void consume(CreatedIndividualCustomerEvent event){
        Customer customer = new Customer();
        customer.setId(event.getId().toString());
        customer.setFirstName(event.getFirstName());
        customer.setLastName(event.getLastName());
        customer.setNationalityId(event.getNationalityId());
        customer.setGender(event.getGender());
        LOGGER.info(String.format("Customer created event consumer => %s",event.toString()));
        filterService.addCustomer(customer);
    }
}
