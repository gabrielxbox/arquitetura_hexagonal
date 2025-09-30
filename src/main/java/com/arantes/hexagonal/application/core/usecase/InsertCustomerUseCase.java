package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.InsertCustpmerOutputPort;
import com.arantes.hexagonal.application.ports.out.SandCpfForValidationOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustpmerOutputPort insertCustpmerOutputPort;

    private final SandCpfForValidationOutputPort sandCpfForValidationOutputPort;

    @Override
    public void insert(Customer customer, String zipCode) {
        var address =  findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustpmerOutputPort.insert(customer);
        sandCpfForValidationOutputPort.sand(customer.getCpf());

    }
}
