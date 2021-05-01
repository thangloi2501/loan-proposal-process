package com.loi.loanproposal.api.service;

import com.loi.loanproposal.db.repository.CustomerRepo;
import com.loi.loanproposal.mapper.CustomerMapper;
import com.loi.loanproposal.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Loi Nguyen
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerMapper customerMapper;

    public Customer getCustomer(String customerCode) {
        return customerMapper.entityToModel(customerRepo.findByCode(customerCode)
                                                        .orElse(com.loi.loanproposal.db.entity.Customer.builder().build()));
    }
}