/**
 * 
 */
package com.intellect.user.response;

import java.util.List;

import com.intellect.dto.Result;
import com.intellect.model.UserModel;

/**
 * @author admin
 *
 */
public class GetUserListResponse {

	private Result result;
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	private List<UserModel> userlist;

	public List<UserModel> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<UserModel> userlist) {
		this.userlist = userlist;
	}
	
	
}

