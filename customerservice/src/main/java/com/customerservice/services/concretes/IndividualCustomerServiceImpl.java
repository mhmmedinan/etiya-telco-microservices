package com.customerservice.services.concretes;

import com.customerservice.entities.concretes.IndividualCustomer;
import com.customerservice.kafka.producers.customers.CreateIndividualCustomerProducer;
import com.customerservice.kafka.producers.customers.DeleteIndividualCustomerProducer;
import com.customerservice.repositories.IndividualCustomerRepository;
import com.customerservice.services.abstracts.IndividualCustomerService;
import com.customerservice.services.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.customerservice.services.dtos.requests.individualCustomers.DeleteIndividualCustomerRequest;
import com.customerservice.services.dtos.responses.individualCustomers.CreateIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.DeleteIndividualCustomerResponse;
import com.customerservice.services.dtos.responses.individualCustomers.GetListIndividualCustomerResponse;
import com.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiya.common.events.customers.CreatedIndividualCustomerEvent;
import com.etiya.common.events.customers.DeletedIndividualCustomerEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {

    private final IndividualCustomerRepository individualCustomerRepository;
    private final CreateIndividualCustomerProducer individualCustomerProducer;
    private final DeleteIndividualCustomerProducer deleteIndividualCustomerProducer;

    @Override
    public CreateIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer mappedIndividualCustomer =
                IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);
        CreateIndividualCustomerResponse response =
                IndividualCustomerMapper.INSTANCE.createIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);


        CreatedIndividualCustomerEvent event = new CreatedIndividualCustomerEvent();
        event.setId(createdIndividualCustomer.getId());
        event.setFirstName(createdIndividualCustomer.getFirstName());
        event.setLastName(createdIndividualCustomer.getLastName());
        event.setNationalityId(createdIndividualCustomer.getNationalityId());
        event.setGender(createdIndividualCustomer.getGender());
        individualCustomerProducer.sendMessage(event);
        return response;

    }

    @Override
    public DeleteIndividualCustomerResponse delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(deleteIndividualCustomerRequest.getId()).get();
        individualCustomer.setDeletedDate(LocalDateTime.now());
        IndividualCustomer deletedIndividualCustomer = individualCustomerRepository.save(individualCustomer);
        DeleteIndividualCustomerResponse response =
                IndividualCustomerMapper.INSTANCE.deleteIndividualCustomerResponseFromIndividualCustomer(deletedIndividualCustomer);

        DeletedIndividualCustomerEvent event = new DeletedIndividualCustomerEvent();
        event.setId(deletedIndividualCustomer.getId());
        event.setDeletedDate(deletedIndividualCustomer.getDeletedDate());
        deleteIndividualCustomerProducer.sendMessage(event);
        return response;
    }

    @Override
    public List<GetListIndividualCustomerResponse> getList() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();
        List<GetListIndividualCustomerResponse> responses = individualCustomers.stream().map(
                IndividualCustomerMapper.INSTANCE::getListIndividualCustomerResponsesFromIndividualCustomer).collect(Collectors.toList());
        return responses;
    }
}
