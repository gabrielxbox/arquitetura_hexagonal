package com.arantes.hexagonal.application.ports.out;

import com.arantes.hexagonal.application.core.domain.Address;

@FunctionalInterface
public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
