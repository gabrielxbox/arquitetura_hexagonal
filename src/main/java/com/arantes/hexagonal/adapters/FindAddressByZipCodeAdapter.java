package com.arantes.hexagonal.adapters;

import com.arantes.hexagonal.adapters.out.claint.FindAddressByZipCodeClient;
import com.arantes.hexagonal.adapters.out.claint.mapper.AddressResponseMapper;
import com.arantes.hexagonal.application.core.domain.Address;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient addressByZipCodeClient;


    @Override
    public Address find(String zipCode) {
    var address = addressByZipCodeClient.find(zipCode);
        return AddressResponseMapper.INSTANCE.toAddress(address);
    }
}
