package com.alissoncs.view;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class MainBean {
	private String errorMessage;
	
	private String successMessage;
	
	@PostConstruct
	public void clear() {
		this.setErrorMessage(null);
		this.setSuccessMessage(null);
		System.out.println("Limpando flash messages");
	}
	
	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
		this.errorMessage = null;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		this.successMessage = null;
	}
}
