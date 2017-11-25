/**
 * 
 */
package com.intellect.userservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.intellect.controller.UserController;
import com.intellect.model.UserModel;
import com.intellect.user.service.UserService;
import com.intellect.user.service.impl.UserServiceImpl;
import com.intellect.util.ValidateRequest;

/**
 * @author admin
 *
 */
public class UserServiceControllerTest {

	@InjectMocks
	private UserController userContrller = new UserController();

	@Mock
	private ValidateRequest validateRequest;

	private MockMvc mockMvc;

	@Mock
	private UserService userServiceImpl;

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userContrller).build();
	}

	@Test
	public void testCreateUserWithBadRequest() throws Exception {

		this.mockMvc.perform(post("/api/user/create").param("email", "mvcemail@test.com").param("fname", "mvcfirst")
				.param("lname", "mvclastname").param("pinCode", "414001").param("birthdate", "1510998908464")
				.param("isActive", "true")).andExpect(status().isBadRequest());

	}

	/**
	 * This method for deleting users rest api
	 * @throws Exception
	 */
	@Test
	public void testDeleteUser() throws Exception {
		List<UserModel> userCollections = getUserModels();
		setFinalStatic(UserServiceImpl.class.getDeclaredField("userCollections"), userCollections);
		this.mockMvc.perform(get("/api/user/delete/{userid}", String.valueOf(System.currentTimeMillis())))
				.andExpect(status().isOk());
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
	 * This method creating dummy users list
	 * 
	 * @return
	 */
	private List<UserModel> getUserModels() {

		List<UserModel> userModels = new ArrayList<>();
		UserModel userModel = new UserModel();
		userModel.setId(String.valueOf(System.currentTimeMillis()));
		userModel.setActive(true);
		userModel.setBirthdate(new Date());
		userModel.setEmail("kunallavand@gmail.com");
		userModel.setFname("kunal");
		userModel.setFname("lawand");
		userModels.add(userModel);
		return userModels;
	}

}
