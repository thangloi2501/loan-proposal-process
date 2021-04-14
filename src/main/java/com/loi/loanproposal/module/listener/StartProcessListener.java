package com.loi.loanproposal.module.listener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class StartProcessListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        log.info("Loan Proposal Process - Start");

        // Proposal ID format: P.YYYYMMDD.UUID
        String proposalId = String.format("P.%s.%s",
                                          LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).replace("-",""),
                                          UUID.randomUUID().toString());
        execution.setVariable("proposalId", proposalId);

        // Proposal Date Time
        execution.setVariable("proposalDateTime", LocalDate.now());
    }
}