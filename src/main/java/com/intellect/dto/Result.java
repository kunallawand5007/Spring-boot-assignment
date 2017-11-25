/**
 * 
 */
package com.intellect.dto;

import com.intellect.enums.ErrorCode;

/**
 * @author admin
 *
 */
public class Result {

	
	private int code;
	private String message;
	private String cause;
	
	public Result(int code, String message, String cause) {
		super();
		this.code = code;
		this.message = message;
		this.cause = cause;
	}
	
	public Result(ErrorCode errorCode) {
	this.code=errorCode.getCode();
	this.message=errorCode.getMessage();
	this.cause=errorCode.getCause();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	
	
	
	

}
