package com.loi.loanproposal.module.start;

import com.loi.loanproposal.dto.ProcessData;
import com.loi.loanproposal.enums.Decision;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class StartProcess_Listener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        log.info("Loan Proposal Process - Start");

        // Proposal ID format: P.YYYYMMDD.UUID
        String proposalId = String.format("P.%s.%s",
                                          LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).replace("-",""),
                                          UUID.randomUUID().toString());
        execution.setVariable("proposalId", proposalId);

        // Proposal Date Time
        execution.setVariable("proposalDateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        ObjectValue processData = Variables.objectValue(ProcessData.builder()
                                                                   .processId(execution.getProcessInstanceId())
                                                                   .rmDecision(Decision.NO.getValue())
                                                                   .build())
                                           .serializationDataFormat(Variables.SerializationDataFormats.JSON).create();

        execution.setVariable("processData", processData);

    }
}