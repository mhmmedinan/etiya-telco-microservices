package com.customerservice.kafka.producers.customers;

import com.etiya.common.events.customers.DeletedIndividualCustomerEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteIndividualCustomerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteIndividualCustomerProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(DeletedIndividualCustomerEvent deletedIndividualCustomerEvent){
        LOGGER.info(String.format("Customer deleted event =>%s",deletedIndividualCustomerEvent.toString()));

        Message<DeletedIndividualCustomerEvent> message = MessageBuilder.withPayload(deletedIndividualCustomerEvent)
                .setHeader(KafkaHeaders.TOPIC,"customer-deleted")
                .build();
        kafkaTemplate.send(message);
    }
}
