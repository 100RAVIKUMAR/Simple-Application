package com.Geekster.EmployeAdress.Repository;

import com.Geekster.EmployeAdress.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface iemployRepo extends JpaRepository<Employee,Long> {
    @Query(value = "select employ_table.* from employ_table \n" +
            "inner join address_table \n" +
            "on employ_table.fk=address_table.address_id\n" +
            "where address_table.address_id=:employId",nativeQuery = true)
    Employee fetchemploybyid(Long employId);
   @Modifying
    @Query(value = "UPDATE employ_table\n" +
            "SET first_name=:firstName\n" +
            "WHERE employ_id=:employId",nativeQuery = true)
    void updatebyid(String firstName,Long employId);


   @Modifying
   @Query(value = "delete from employ_table\n" +
           "where employ_id=:employId",nativeQuery = true)
           void deletebyid(Long employId);
}
