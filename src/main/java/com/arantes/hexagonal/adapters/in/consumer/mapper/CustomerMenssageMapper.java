package com.arantes.hexagonal.adapters.in.consumer.mapper;

import com.arantes.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.arantes.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMenssageMapper {

    CustomerMenssageMapper INSTANCE = Mappers.getMapper(CustomerMenssageMapper.class);


    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
