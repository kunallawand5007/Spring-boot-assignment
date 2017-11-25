/**
 * 
 */
package com.intellect.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.intellect.dto.Result;
import com.intellect.enums.ErrorCode;
import com.intellect.model.UserModel;

/**
 * @author admin
 *
 */
@Component
public class ValidateRequest {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public Result validate(UserModel userModel) {
		Result result = null;

		if (userModel == null) {
			result = new Result(ErrorCode.PARAMETER_MISSING);
			return result;
		}

		if (userModel.getEmail() == null || "".equals(userModel.getEmail())) {
			result = new Result(ErrorCode.PARAMETER_MISSING);
			result.setCause("Email idis missing");
			return result;
		} else {

			String email = userModel.getEmail();
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
			boolean find = matcher.find();
			if (!find) {
				result = new Result(ErrorCode.PARAMETER_MISSING);
				result.setCause("Please enter valid email-id");
				return result;

			}
		}

		if (userModel.getPinCode() == null || "".equals(userModel.getPinCode())) {
			result = new Result(ErrorCode.PARAMETER_MISSING);
			result.setCause("Pincode is missing");
			return result;

		}

		if (userModel.getBirthdate() == null || "".equals(userModel.getBirthdate())) {
			result = new Result(ErrorCode.PARAMETER_MISSING);
			result.setCause("birthdate is missing");
			return result;

		}else{
			 
			Date date=userModel.getBirthdate();
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(date);
			 Calendar current = Calendar.getInstance();
			 current.setTime(new Date());
			 
			 if(current.before(calendar)){
					result = new Result(ErrorCode.PARAMETER_MISSING);
					result.setCause("birthdate is not valid should before current date");
					return result;
    			 
			 }
		}

		result = new Result(ErrorCode.SUCCESS);

		return result;

	}
}
