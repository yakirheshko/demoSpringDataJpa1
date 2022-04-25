package com.example.entity;

import com.example.request.CreateStudentRequest;
import com.example.request.UpdateStudentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @JsonProperty("first_name")
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Transient
    private String fullName;

    public Student(CreateStudentRequest createStudentRequest){
        this.firstName = createStudentRequest.getFirstName();
        this.lastName = createStudentRequest.getLastName();
        this.email = createStudentRequest.getEmail();
    }

    public Student(UpdateStudentRequest updateStudentRequest){
        this.id = updateStudentRequest.getId();
        this.firstName = updateStudentRequest.getFirstName();
        this.lastName = updateStudentRequest.getLastName();
        this.email = updateStudentRequest.getEmail();
    }

}
