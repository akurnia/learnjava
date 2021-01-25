package com.tutorial.failfast.exception;

public class NoDataFoundException extends RuntimeException {

	public NoDataFoundException() {

		super("No data found");
	}
}
