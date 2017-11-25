/**
 * 
 */
package com.intellect.user.request;

import com.intellect.dto.Result;
import com.intellect.model.UserModel;

/**
 * @author admin
 *
 */
public class CreateUserRequest {

	private Result result;
	private UserModel user;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

}
