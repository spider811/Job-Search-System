package com.cg.jss.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JobNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
}
