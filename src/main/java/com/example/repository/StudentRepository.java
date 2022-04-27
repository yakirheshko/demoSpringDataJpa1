package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByFirstNameIn(List<String> firstNames);

    List<Student> findByFirstNameContains(String firstName);

    List<Student> findByFirstNameStartsWith(String firstName);

    @Query("from Student where firstName = :firstName and lastName = :lastname")
    List<Student> findByFirstNameAndLastNameJPQL(String firstName, @Param("lastname") String lastName);

    @Modifying
    @Transactional
    @Query("update Student set firstName = :firstName where lastName = :lastName")
    Integer updateStudentFirstNameByLastNameJPQL(String lastName, String firstName);

    @Modifying
    @Transactional
    @Query("delete from Student where lastName = :lastName")
    Integer deleteStudentByLastNameJPQL(String lastName);

    List<Student> findByAddressCity(String city);

    @Query("From Student where address.city = :city")
    List<Student> findByAddressCityJPQL(String city);

}
