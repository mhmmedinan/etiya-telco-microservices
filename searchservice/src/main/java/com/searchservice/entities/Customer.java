package com.searchservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "search-customer")
public class Customer {

    @Id
    private String id;

    @Field(name = "firstName")
    private String firstName;

    @Field(name = "lastName")
    private String lastName;

    @Field(name = "nationalityId")
    private String nationalityId;

    @Field(name = "gender")
    private String gender;

    @Field(name = "deleted_date")
    private LocalDateTime deletedDate;
}
