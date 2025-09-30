package com.arantes.hexagonal.adapters.out.repository.mapper;

import com.arantes.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arantes.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AddressEntityMapper.class})
public interface CustomerEntityMapper {

    CustomerEntityMapper INSTANCE = Mappers.getMapper(CustomerEntityMapper.class);

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
