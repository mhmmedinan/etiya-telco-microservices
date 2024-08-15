package com.searchservice.kafka.consumers.customers;

import com.etiya.common.events.customers.CreatedIndividualCustomerEvent;
import com.etiya.common.events.customers.DeletedIndividualCustomerEvent;
import com.searchservice.entities.Customer;
import com.searchservice.services.abstracts.FilterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteIndividualCustomerConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateIndividualCustomerConsumer.class);
    private final FilterService filterService;

    @KafkaListener(topics = "customer-deleted",groupId ="deleted-customer")
    private void consume(DeletedIndividualCustomerEvent event){
         Customer customer = filterService.getById(event.getId().toString());
         customer.setDeletedDate(event.getDeletedDate());
         this.filterService.deleteCustomer(customer);
    }
}
