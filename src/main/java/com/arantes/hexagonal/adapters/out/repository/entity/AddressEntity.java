package com.arantes.hexagonal.adapters.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class AddressEntity implements Serializable {

    private String street;
    private String city;
    private String state;
}
