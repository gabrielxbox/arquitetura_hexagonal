package com.arantes.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    private String id;

    private String name;

    private String zipCode;

    private String cpf;

    private boolean isValidCpf;

}
