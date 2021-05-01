package com.loi.loanproposal.module.start;

import com.loi.loanproposal.dto.ProcessData;
import com.loi.loanproposal.enums.Decision;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.TypedValue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Loi Nguyen
 */
@Slf4j
public class StartProcess_Listener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        log.info("Loan Proposal Process - Start");

        log.info("TODO: >>>>>>>>>>>>>>>");
        log.info("1. Add business rule for approval level evaluation                        (DONE)");
        log.info("2. Get customer info by customer code from db                             (TODO)");
        log.info("3. User task assignment: to user (back and forth), to group (round-robin) (TODO)");
        log.info("4. Unit tests                                                             (TODO)");
        log.info(">>>>>>>>>>>>>>>>>>>>>");

        // Proposal ID format: P.YYYYMMDD.UUID
        String proposalId = String.format("P.%s.%s",
                                          LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).replace("-", ""),
                                          UUID.randomUUID().toString());
        execution.setVariable("proposalId", proposalId);

        // Proposal Date Time
        execution.setVariable("proposalDateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        TypedValue processData = Variables.objectValue(ProcessData.builder()
                                                                  .processId(execution.getProcessInstanceId())
                                                                  .rmDecision(Decision.NO.getValue())
                                                                  .build(), false).create();

        execution.setVariable("processData", processData);
    }
}