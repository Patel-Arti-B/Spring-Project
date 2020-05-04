package com.xworkz.commonmodule.exception;

import org.apache.log4j.Logger;

public class ControllerException extends Exception {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ControllerException.class);

	public ControllerException() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public String getMessage() {
		logger.info("Inside getMessage()...");
		return "Controller Exception Occured...";
	}

}
