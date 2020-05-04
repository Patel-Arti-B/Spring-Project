package com.xworkz.commonmodule.exception;

import org.apache.log4j.Logger;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ServiceException.class);

	public ServiceException() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public String getMessage() {
		logger.info("Inside getMessage()...");
		return "Exception Occured in Controller";
	}
}
