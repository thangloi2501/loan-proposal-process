package com.loi.loanproposal.module.proposedocument;

import com.loi.loanproposal.dto.ProcessData;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import static org.camunda.spin.Spin.JSON;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class ProposeDocument_EndListener implements ExecutionListener {

        @Override
        public void notify(DelegateExecution execution) {
                ProcessData processData = JSON(execution.getVariable("processData").toString()).mapTo(ProcessData.class);
                log.info(" ------>>>>>>>" + processData.getRmDecision());
                execution.setVariable("processData", processData);
        }
}