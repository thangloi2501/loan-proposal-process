package com.loi.loanproposal.mapper;

import com.loi.loanproposal.db.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Loi Nguyen
 *
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "model.code", target = "code"),
            @Mapping(source = "model.name", target = "name"),
            @Mapping(source = "model.phoneNumber", target = "phoneNumber"),
            @Mapping(source = "model.address", target = "address"),
            @Mapping(source = "model.type", target = "type"),
    })
    Customer modelToEntity(com.loi.loanproposal.model.Customer model);

    com.loi.loanproposal.model.Customer entityToModel(Customer customer);
}