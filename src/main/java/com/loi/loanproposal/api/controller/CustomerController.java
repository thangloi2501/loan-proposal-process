package com.loi.loanproposal.api.controller;

import com.loi.loanproposal.api.service.CustomerService;
import com.loi.loanproposal.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author Loi Nguyen
 */
@RestController
@Validated
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerCode}")
    public Customer getCustomer(@PathVariable("customerCode")
                                @NotEmpty(message = "{customer.api.error.customer-code-cannot-be-empty}")
                                String customerCode) {
        return customerService.getCustomer(customerCode);
    }
}