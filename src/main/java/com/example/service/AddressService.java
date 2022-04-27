package com.example.service;

import com.example.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public String deleteAddress(long id) {
        addressRepository.deleteById(id);
        return "address has been deleted successfully";
    }
}
