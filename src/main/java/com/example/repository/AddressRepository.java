package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Address1;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address1, Long> {

}
