package com.loi.loanproposal.mapper;

import com.loi.loanproposal.db.entity.CustomerType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Loi Nguyen
 *
 */
@Mapper(componentModel = "spring")
public interface CustomerTypeMapper {
    @Mappings({
            @Mapping(source = "model.code", target = "code"),
            @Mapping(source = "model.name", target = "name"),
    })
    CustomerType modelToEntity(com.loi.loanproposal.model.CustomerType model);

    com.loi.loanproposal.model.CustomerType entityToModel(CustomerType customerType);
}