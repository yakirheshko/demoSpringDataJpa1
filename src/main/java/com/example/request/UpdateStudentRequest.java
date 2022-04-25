package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {

    @NotNull(message = "student id is required")
    private long id;

    @JsonProperty("first_name")
    @NotNull(message = "first name is required")
    @NotBlank(message = "first name is required")
    private String firstName;

    private String lastName;

    private String email;
}
