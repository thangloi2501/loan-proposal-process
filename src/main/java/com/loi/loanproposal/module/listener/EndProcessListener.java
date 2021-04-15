package com.loi.loanproposal.module.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class EndProcessListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        log.info("Loan Proposal Process - End");

        log.info(String.format("Process Data: %s %s %s %s %s %s",
                               execution.getVariable("proposalId"),
                               execution.getVariable("proposalDateTime"),
                               execution.getVariable("rmDecision"),
                               execution.getVariable("control1Decision"),
                               execution.getVariable("isNeedControl2"),
                               execution.getVariable("control2Decision")));
    }
}