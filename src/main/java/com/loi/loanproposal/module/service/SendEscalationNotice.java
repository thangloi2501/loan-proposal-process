package com.loi.loanproposal.module.service;

import com.loi.loanproposal.configuration.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("sendEscalationNotice")
public class SendEscalationNotice implements JavaDelegate {

	private final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Sent escalation notice");
	}

}
