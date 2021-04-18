package com.loi.loanproposal.module.end;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class EndProcess_Listener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        log.info("Loan Proposal Process - End");

        log.info(String.format("Process Data: %s %s %s",
                               execution.getVariable("proposalId"),
                               execution.getVariable("proposalDateTime"),
                               execution.getVariable("processData")));
    }
}