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
public class CustomerEntity implements Serializable {

    private String id;
    private String name;
    private String email;
    private AddressEntity address;


}
