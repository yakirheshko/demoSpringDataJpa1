package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class CreateStudentRequest {

    @JsonProperty("first_name")
    @NotBlank(message = "First name is required")
    @NotNull(message = "First name must be not null")
    private String firstName;

    private String lastName;

    private String email;
}
