package com.Geekster.EmployeAdress.Repository;

import com.Geekster.EmployeAdress.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface iaddressRepo extends JpaRepository<Address,Long> {
    @Query(value = "select address_table.* from address_table \n" +
            "inner join employ_table \n" +
            "on employ_table.fk=address_table.address_id\n" +
            "where address_table.address_id=:addressId",nativeQuery = true)
    Address getadbyid(Long addressId);
    @Modifying
    @Query(value = "UPDATE address_table\n" +
            "SET zip_code= :zipCode\n" +
            "where address_id= :addressId",nativeQuery = true)
    void updatebyid(String zipCode, Long addressId);


}
