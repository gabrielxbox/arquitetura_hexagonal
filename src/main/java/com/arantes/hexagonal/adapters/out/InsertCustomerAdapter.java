package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.InsertCustpmerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustpmerOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public void insert(Customer customer) {
        customerRepository.save(CustomerEntityMapper.INSTANCE.toCustomerEntity(customer));
    }
}
