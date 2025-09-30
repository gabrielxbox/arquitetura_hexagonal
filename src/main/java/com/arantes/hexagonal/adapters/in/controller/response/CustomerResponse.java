package com.arantes.hexagonal.adapters.in.controller.response;

import com.arantes.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse implements Serializable {

    private String id;

    private String name;

    private AddressResponse address;

    private String cpf;

    private boolean isValidCpf;
}

