package com.customerservice.kafka.producers.customers;

import com.etiya.common.events.customers.CreatedIndividualCustomerEvent;
import lombok.AllArgsConstructor;
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
public class CreateIndividualCustomerProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateIndividualCustomerProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(CreatedIndividualCustomerEvent createIndividualCustomerEvent){
        LOGGER.info(String.format("Customer created event =>%s",createIndividualCustomerEvent.toString()));

        Message<CreatedIndividualCustomerEvent> message = MessageBuilder.withPayload(createIndividualCustomerEvent)
                .setHeader(KafkaHeaders.TOPIC,"customer-created")
                .build();
        kafkaTemplate.send(message);
    }
}
