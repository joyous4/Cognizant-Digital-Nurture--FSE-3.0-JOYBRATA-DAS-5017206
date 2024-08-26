package com.example.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


//Created Data Transfer Objects as required by Excercise 7
@Data

//CustomerDTO class updated with validation constraints as required by Excercise 8

//RepresentationModel is used as part of Hateoas used in Excercise 9 for API documentation
public class CustomerDTO extends RepresentationModel<CustomerDTO> {

    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Address cannot be null")
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    private String address;
}
