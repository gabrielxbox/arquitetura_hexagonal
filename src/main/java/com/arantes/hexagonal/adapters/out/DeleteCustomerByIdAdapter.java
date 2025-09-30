package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPutPort {

    private final CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
