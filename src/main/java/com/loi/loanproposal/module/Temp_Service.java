package com.loi.loanproposal.module;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @author Loi Nguyen
 */
@Slf4j
public class Temp_Service implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Evaluating approval level...");
        execution.setVariable("isNeedApproval2", true);
    }

}
