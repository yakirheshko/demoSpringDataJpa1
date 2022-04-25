package com.example.response;

import com.example.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private long id;
    @JsonProperty("first_name")
    private String firstName;
    private String lastName;
    private String email;

    public StudentResponse(Student student){
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
}
