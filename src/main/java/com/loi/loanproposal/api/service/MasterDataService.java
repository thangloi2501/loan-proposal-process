package com.loi.loanproposal.api.service;

import com.loi.loanproposal.db.repository.CustomerTypeRepo;
import com.loi.loanproposal.db.repository.LoanTypeRepo;
import com.loi.loanproposal.mapper.CustomerTypeMapper;
import com.loi.loanproposal.mapper.LoanTypeMapper;
import com.loi.loanproposal.model.CustomerType;
import com.loi.loanproposal.model.LoanType;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Loi Nguyen
 */
@Service
public class MasterDataService {

    @Autowired
    CustomerTypeRepo customerTypeRepo;

    @Autowired
    LoanTypeRepo loanTypeRepo;

    @Autowired
    CustomerTypeMapper customerTypeMapper;

    @Autowired
    LoanTypeMapper loanTypeMapper;

    public List<CustomerType> getCustomerTypes() {

        return StreamEx.of(customerTypeRepo.findAll())
                       .map(customerTypeMapper::entityToModel)
                       .toList();
    }

    public List<LoanType> getLoanTypes() {
        return StreamEx.of(loanTypeRepo.findAll())
                       .map(loanTypeMapper::entityToModel)
                       .toList();
    }
}