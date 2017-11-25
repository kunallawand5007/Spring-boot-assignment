/**
 * 
 */
package com.intellect.enums;

/**
 * @author admin
 *
 */
public enum ErrorCode {

	SUCCESS(200,"SUCCESS","SUCCESS"),
	NOT_FOUND(404,"NOT Found","NOT Found"),
	PARAMETER_MISSING(403,"Parameter missing","Parameter missing"),
	PARAMETER_EXIST(203,"parameter already exist","parameter already exist"),
	ERROR(500,"ERROR","ERROR");
	private int code;
	private String message;
	private String cause;
	
	ErrorCode(int code,String message,String cause){
		this.code=code;
		this.message=message;
		this.cause=cause;
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
