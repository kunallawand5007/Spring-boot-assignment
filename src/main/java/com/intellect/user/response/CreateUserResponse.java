/**
 * 
 */
package com.intellect.user.response;

import com.intellect.dto.Result;

/**
 * @author admin
 *
 */
public class CreateUserResponse {

	private Result result;
	private String userId;
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
