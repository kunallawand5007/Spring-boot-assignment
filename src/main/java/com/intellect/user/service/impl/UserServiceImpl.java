/**
 * 
 */
package com.intellect.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.intellect.dto.Result;
import com.intellect.enums.ErrorCode;
import com.intellect.model.UserModel;
import com.intellect.user.service.UserService;

/**
 * @author admin
 *
 */
@Service
public class UserServiceImpl implements UserService {

	public static List<UserModel> userCollections = new ArrayList<UserModel>();

	@Override
	public String createUser(UserModel userModel) {
		
		boolean flag=false;
		
		for (UserModel userModelObj : userCollections) {
			
			if(userModelObj.getEmail().equals(userModel.getEmail())){
				flag=true;
				break;
			}
		}
		
		if(flag){
			return null;
		}
		
		String id = String.valueOf(System.currentTimeMillis());
		userModel.setId(id);
		userCollections.add(userModel);
		return id;
	}

	@Override
	public Result deleteUser(String userid) {
		Result result=null;
		
		if(userid==null || "".equals(userid)){
			result=new Result(ErrorCode.PARAMETER_MISSING);
			return result;
		}
		
		boolean flag=false;
		
		for (UserModel userModel : userCollections) {
		
			 if(userModel.getId().equals(userid)){
				 flag=true;
				 break;
		}
		}
	if(!flag){
		return result=new Result(ErrorCode.NOT_FOUND);
	}
			 
	ListIterator<UserModel> listIterator = userCollections.listIterator();
		  while (listIterator.hasNext()) {
			   UserModel next = listIterator.next();
			   if(next.getId().equals(userid) && next.isActive()){
				   listIterator.remove();
			    break;
			   }
		}
		  
	result=new Result(ErrorCode.SUCCESS);		  
	 return result;			   

	}

	@Override
	public Result updateUser(UserModel usermodel) {
		boolean flag=true;
		
        UserModel model=null;
        int index=0;
        
		for (UserModel userModelObj : userCollections) {
		
			 if(userModelObj.getId().equals(usermodel.getId())){
				 flag=true;
				 model=userModelObj;
				 index = userCollections.indexOf(userModelObj);
				 break;
		}
		}
	if(!flag){
		return new Result(ErrorCode.NOT_FOUND);
	}
	
	 model.setBirthdate(usermodel.getBirthdate());
	 model.setPinCode(usermodel.getPinCode());
	
	
	 userCollections.set(index, model);
		return  new Result(ErrorCode.SUCCESS);
	}

	@Override
	public List<UserModel> userList() {
		return userCollections;
	}

}
