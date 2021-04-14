package com.loi.loanproposal.module.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author Loi Nguyen
 */
@Component("informCustomerService")
@Slf4j
public class InformCustomerService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info(String.format("Inform Customer Result: %s %s %s",
                               execution.getVariable("proposalId"),
                               execution.getVariable("proposalDateTime"),
                               execution.getVariable("rmDecision")));
    }

}
