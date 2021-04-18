package com.loi.loanproposal.module.sendescalation;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author Loi Nguyen
 *
 */
@Component("sendEscalationNotice")
@Slf4j
public class SendEscalationNoticeService implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.info("Sent escalation notice");
	}

}