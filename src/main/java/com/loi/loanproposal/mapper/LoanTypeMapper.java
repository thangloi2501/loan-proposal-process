package com.loi.loanproposal.mapper;

import com.loi.loanproposal.db.entity.LoanType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Loi Nguyen
 *
 */
@Mapper(componentModel = "spring")
public interface LoanTypeMapper {
    @Mappings({
            @Mapping(source = "model.code", target = "code"),
            @Mapping(source = "model.name", target = "name"),
    })
    LoanType modelToEntity(com.loi.loanproposal.model.LoanType model);

    com.loi.loanproposal.model.LoanType entityToModel(LoanType loanType);
}