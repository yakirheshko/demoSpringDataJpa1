package com.example.controller;

import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address/")
public class AddressConstroler {

    @Autowired
    AddressService addressService;

    @DeleteMapping("delete")
    public String deleteAddress(@RequestParam long id){
        return addressService.deleteAddress(id);
    }

}
