/**
 * 
 */
package com.intellect.user.service;

import java.util.List;

import com.intellect.dto.Result;
import com.intellect.model.UserModel;

/**
 * @author admin
 *
 */
public interface UserService {

	/**
	 * This method for creating user if exist return null
	 * @param userModel
	 * @return String
	 */
	public String createUser(UserModel userModel);
	
	/**
	 * This method for deleting users from collection
	 * @param userid
	 * @return Result
	 */
	public Result deleteUser(String userid);
	
	/**
	 * This method for updating user
	 * @param usermodel
	 * @return Result
	 */
	public Result updateUser(UserModel usermodel);
	
	public List<UserModel> userList();
	
}
