package com.loi.loanproposal.api.service;

import com.loi.loanproposal.db.entity.CustomerType;
import com.loi.loanproposal.db.entity.LoanType;
import com.loi.loanproposal.db.repository.CustomerTypeRepo;
import com.loi.loanproposal.db.repository.LoanTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Loi Nguyen
 *
 */
@Component
public class MasterDataService {

    @Autowired
    CustomerTypeRepo customerTypeRepo;

    @Autowired
    LoanTypeRepo loanTypeRepo;

    public List<CustomerType> getCustomerTypes() {
        return customerTypeRepo.findAll();
    }

    public List<LoanType> getLoanTypes() {
        return loanTypeRepo.findAll();
    }
}