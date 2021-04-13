package com.loi.loanproposal.module.listener;

import java.util.Date;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

@Slf4j
public class StartProcessListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        
        log.info("Loan Proposal Process - Start");
        //generating referenceNo
        String refNo = "SH" + String.valueOf(new Date().getTime());
        //Set the variable into top execution scope
        execution.setVariable("referenceNo", refNo);
    }
}