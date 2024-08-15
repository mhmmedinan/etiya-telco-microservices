package com.etiya.common.events.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeletedIndividualCustomerEvent {

    private UUID id;
    private LocalDateTime deletedDate;
}
