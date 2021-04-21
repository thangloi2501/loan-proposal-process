package com.loi.loanproposal.api.controller;

import com.loi.loanproposal.api.service.MasterDataService;
import com.loi.loanproposal.model.LabelValuePair;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loi Nguyen
 */
@RestController
@RequestMapping("/api/master-data")
public class MasterDataController {

    @Autowired
    MasterDataService dataService;

    @GetMapping("/customer-types")
    public LabelValuePair[] fetchCustomerTypes() {
        return StreamEx.of(dataService.getCustomerTypes())
                       .map(customerType -> LabelValuePair.builder()
                                                          .value(customerType.getCode())
                                                          .label(customerType.getName())
                                                          .build())
                       .toArray(LabelValuePair.class);
    }

    @GetMapping("/loan-types")
    public LabelValuePair[] fetchLoanTypes() {
        return StreamEx.of(dataService.getLoanTypes())
                       .map(loanType -> LabelValuePair.builder()
                                                      .value(loanType.getCode())
                                                      .label(loanType.getName())
                                                      .build())
                       .toArray(LabelValuePair.class);
    }
}