package com.arantes.hexagonal.adapters.out.claint.mapper;

import com.arantes.hexagonal.adapters.out.claint.response.AddressResponse;
import com.arantes.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    AddressResponseMapper INSTANCE = Mappers.getMapper(AddressResponseMapper.class);

    Address toAddress(AddressResponse addressResponse);
}
