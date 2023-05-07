package com.Geekster.EmployeAdress.Service;

import com.Geekster.EmployeAdress.Repository.iaddressRepo;
import com.Geekster.EmployeAdress.models.Address;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    iaddressRepo addressrepo;

   @Transactional
    public List<Address> getadress() {
        return addressrepo.findAll();
    }

    public Address getadbyid(Long addressId) {
       return addressrepo.getadbyid(addressId);
    }
    @Transactional
    public void updatebyid(String zipCode, Long addressId) {
        addressrepo.updatebyid(zipCode,addressId);
    }


    public void addadress(Address address) {
       addressrepo.save(address);
    }
}
