package com.loi.loanproposal.configuration;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author Loi Nguyen
 *
 */
@Component("logger")
public class Logger implements JavaDelegate {
 
  private final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "processDefinitionId=" + execution.getProcessDefinitionId()
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", activtyName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + " \n\n");
  }
}
