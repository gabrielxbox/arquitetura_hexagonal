package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.arantes.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;

    @Override
    public void update(Customer customer, String zipCode) {
         findCustomerByIdOutputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPutPort.update(customer);
    }
}
