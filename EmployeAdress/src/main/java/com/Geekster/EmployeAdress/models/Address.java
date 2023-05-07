package com.Geekster.EmployeAdress.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AddressTable")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String streetName;

    private String cityName;

    private String stateName;

    private String zipCode;
    @JsonIgnore
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Employee employee;
}
