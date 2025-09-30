package com.arantes.hexagonal.adapters.out.repository.mapper;

import com.arantes.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.arantes.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressEntityMapper {

    AddressEntityMapper INSTANCE = Mappers.getMapper(AddressEntityMapper.class);

    AddressEntity toAddressEntity(Address address);

    Address toAddress(AddressEntity addressEntity);
}
