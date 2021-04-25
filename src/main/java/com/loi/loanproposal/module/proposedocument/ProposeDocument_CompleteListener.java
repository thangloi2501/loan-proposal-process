package com.loi.loanproposal.module.proposedocument;

import com.loi.loanproposal.dto.DMN;
import com.loi.loanproposal.dto.ProcessData;
import com.loi.loanproposal.model.Loan;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import static org.camunda.spin.Spin.JSON;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class ProposeDocument_CompleteListener implements TaskListener {
        @Override
        public void notify(DelegateTask delegateTask) {
                ProcessData processData = JSON(delegateTask.getVariable("processData").toString()).mapTo(ProcessData.class);
                processData.setRmCode(delegateTask.getAssignee());
                log.info(" ------>>>>>>>" + processData);
                delegateTask.setVariable("processData", processData);

                // Prepare for DMN
                Loan loan = JSON(delegateTask.getVariable("loan").toString()).mapTo(Loan.class);
                DMN dmn = DMN.builder()
                             .loanAmount(loan.getAmount())
                             .loanTerm(loan.getTerm())
                             .build();
                delegateTask.setVariable("dmn", dmn);
        }
}