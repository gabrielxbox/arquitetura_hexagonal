package com.arantes.hexagonal.adapters.in.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse implements Serializable {

    private String street;

    private String city;

    private String state;
}
