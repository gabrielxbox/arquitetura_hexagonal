package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter  implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> find(String id) {
        return  customerRepository.findById(id).stream().filter(Objects::nonNull)
                .findAny()
                .map(CustomerEntityMapper.INSTANCE::toCustomer)
                .or(() -> Optional.empty());
    }
}
