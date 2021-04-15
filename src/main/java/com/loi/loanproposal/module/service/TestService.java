package com.loi.loanproposal.module.service;

import com.loi.loanproposal.enums.Decision;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author Loi Nguyen
 *
 */
@Component("testService")
@Slf4j
public class TestService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Test Service:" + execution.getVariable("proposalId"));

        execution.setVariable("rmDecision", Decision.APPROVED);
    }

}
