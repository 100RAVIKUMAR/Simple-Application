package com.Geekster.EmployeAdress.Controller;

import com.Geekster.EmployeAdress.Service.AddressService;
import com.Geekster.EmployeAdress.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping(value = "/get")
    public List<Address> getadress(){
        return addressService.getadress();
    }
    @GetMapping("/getad/{addressId}")
    public Address getadbyid(@PathVariable Long addressId){
        return addressService.getadbyid(addressId);
    }
    @PutMapping("/update/{addressId}/zip/{zipCode}")
    public void updatebyid(@PathVariable String zipCode,@PathVariable Long addressId){
        addressService.updatebyid(zipCode,addressId);
    }
    @PostMapping("/add")
    public void addadress(@RequestBody Address address){
         addressService.addadress(address);
    }

}
