package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdIutputPort;
import com.arantes.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerByIdIutputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

    }
}
