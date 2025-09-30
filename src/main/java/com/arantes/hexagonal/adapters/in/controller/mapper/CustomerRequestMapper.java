package com.arantes.hexagonal.adapters.in.controller.mapper;

import com.arantes.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arantes.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arantes.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    CustomerRequestMapper INSTANCE = Mappers.getMapper(CustomerRequestMapper.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "address", ignore = true),
        @Mapping(target = "isValidCpf", ignore = true),
    })
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
