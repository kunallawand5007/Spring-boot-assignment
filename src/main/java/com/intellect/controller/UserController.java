/**
 * 
 */
package com.intellect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.dto.Result;
import com.intellect.enums.ErrorCode;
import com.intellect.model.UserModel;
import com.intellect.user.response.CreateUserResponse;
import com.intellect.user.service.UserService;
import com.intellect.util.ValidateRequest;

/**
 * @author admin
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ValidateRequest validator;

	/**
	 * This is POST method call to save user
	 * 
	 * @param user
	 * @return id
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ResponseEntity<CreateUserResponse> createUser(@RequestBody UserModel user) {

		CreateUserResponse createUserResponse = new CreateUserResponse();
		Result result = null;

		Result validate = validator.validate(user);
		if (validate.getCode() != ErrorCode.SUCCESS.getCode()) {
			createUserResponse.setResult(validate);
			return new ResponseEntity<CreateUserResponse>(createUserResponse, HttpStatus.OK);
		}
		String createUserId = userService.createUser(user);

		if (createUserId == null) {
			result = new Result(ErrorCode.PARAMETER_EXIST);
			createUserResponse.setResult(result);
			return new ResponseEntity<CreateUserResponse>(createUserResponse, HttpStatus.OK);

		}
		result = new Result(ErrorCode.SUCCESS);
		createUserResponse.setUserId(createUserId);
		createUserResponse.setResult(result);
		result.setMessage("User created successfully");
		return new ResponseEntity<CreateUserResponse>(createUserResponse, HttpStatus.OK);

	}

	/**
	 * This POST method call to save user
	 * 
	 * @param user
	 * @return Result
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public ResponseEntity<Result> updateUser(@RequestBody UserModel user) {

		Result updateUser = userService.updateUser(user);
		return new ResponseEntity<Result>(updateUser, HttpStatus.OK);

	}

	/**
	 * This is GET method call to list users
	 * 
	 * @return List<UserModel>
	 */
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ResponseEntity<List<UserModel>> listUser() {
		return new ResponseEntity<List<UserModel>>(userService.userList(), HttpStatus.OK);

	}

	/**
	 * This is GET method call to delete user
	 * 
	 * @param userid
	 * @return Result
	 */
	@RequestMapping(value = "/user/delete/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Result> deleteUser(@PathVariable String userid) {
		Result deleteUser = userService.deleteUser(userid);
		return new ResponseEntity<Result>(deleteUser, HttpStatus.OK);

	}

}
