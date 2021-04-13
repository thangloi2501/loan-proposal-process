package com.loi.loanproposal.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("Position")
public class Position implements Serializable {

	private static final long serialVersionUID = 4580085259982608206L;
	
	private String positionType;
	private Person replacement;
	private String jobTitle;
	private String ild;
	
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public Person getReplacement() {
		return replacement;
	}
	public void setReplacement(Person replacement) {
		this.replacement = replacement;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getIld() {
		return ild;
	}
	public void setIld(String ild) {
		this.ild = ild;
	}
}