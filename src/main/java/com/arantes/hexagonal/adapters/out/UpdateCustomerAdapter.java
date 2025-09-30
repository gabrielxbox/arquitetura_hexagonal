package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPutPort {

    private final CustomerRepository customerRepository;

    @Override
    public void update(Customer customer) {
        var customerEntity = CustomerEntityMapper.INSTANCE.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
