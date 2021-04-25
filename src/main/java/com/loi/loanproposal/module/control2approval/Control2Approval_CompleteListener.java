package com.loi.loanproposal.module.control2approval;

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
public class Control2Approval_CompleteListener implements TaskListener {
        @Override
        public void notify(DelegateTask delegateTask) {
                ProcessData processData = JSON(delegateTask.getVariable("processData").toString()).mapTo(ProcessData.class);
                processData.setRmManager2Code(delegateTask.getAssignee());
                log.info(" ------>>>>>>>" + processData);
                delegateTask.setVariable("processData", processData);
        }
}