package com.loi.loanproposal.module.control1approval;

import com.loi.loanproposal.dto.ProcessData;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import static org.camunda.spin.Spin.JSON;

/**
 * @author Loi Nguyen
 *
 */
@Slf4j
public class Control1Approval_CompleteListener implements TaskListener {
        @Override
        public void notify(DelegateTask delegateTask) {
                ProcessData processData = JSON(delegateTask.getVariable("processData").toString()).mapTo(ProcessData.class);
                processData.setRmManager1Code(delegateTask.getAssignee());
                log.info(" ------>>>>>>>" + processData);
                delegateTask.setVariable("processData", processData);
        }
}