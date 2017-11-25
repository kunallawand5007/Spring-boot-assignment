/**
 * 
 */
package com.intellect.userservice;

import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.intellect.model.UserModel;
import com.intellect.user.service.impl.UserServiceImpl;

/**
 * @author admin
 *
 */
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This test cases for user already exist
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws Exception
	 */
	@Test
	public void testCreateUser() throws NoSuchFieldException, SecurityException, Exception {

		userServiceImpl = Mockito.mock(userServiceImpl.getClass());

		List<UserModel> userCollections = getUserModels();
		setFinalStatic(UserServiceImpl.class.getDeclaredField("userCollections"), userCollections);
		Mockito.when(userServiceImpl.createUser(getUserModel())).thenReturn(null);
		String createUser = userServiceImpl.createUser(getUserModel());
		assertNull(createUser);
	}

	/**
	 * This method for mocking static field in UserServiceImpl class
	 * 
	 * @param field
	 * @param newValue
	 * @throws Exception
	 */
	static void setFinalStatic(Field field, Object newValue) throws Exception {
		field.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null, newValue);
	}

	/**
	 * @return
	 */
	private UserModel getUserModel() {
		UserModel userModel = new UserModel();
		userModel.setActive(true);
		userModel.setBirthdate(new Date());
		userModel.setEmail("kunallavand@gmail.com");
		return userModel;

	}

	/**
	 * @return
	 */
	private List<UserModel> getUserModels() {

		List<UserModel> userModels = new ArrayList<>();
		UserModel userModel = new UserModel();
		userModel.setActive(true);
		userModel.setBirthdate(new Date());
		userModel.setEmail("kunallavand@gmail.com");
		userModel.setFname("kunal");
		userModel.setFname("lawand");
		userModels.add(userModel);
		return userModels;
	}

}
