package com.sp.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sp.model.User;
import com.sp.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserCrt.class)
public class UserCrtIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService service;

	@Test
	public void givenUsers_thenReturnJsonArray() throws Exception {
		User elmut = new User(1, "Elmut", "password", 0.0);
		User jacky = new User(1, "Jacky", "password", 100.0);

		List<User> allUsers = Lists.list(elmut, jacky);

		given(service.getAll()).willReturn(allUsers);

		mvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].name", is(elmut.getName())))
			.andExpect(jsonPath("$[1].name", is(jacky.getName())));
	}
	
	@Test
	public void givenUser_thenReturnJsonObject() throws Exception {
		Integer userId = 1;
		User elmut = new User(userId, "Elmut", "password", 0.0);

		given(service.getUser(userId)).willReturn(elmut);
		
		mvc.perform(get("/" + userId))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(elmut.getId())))
			.andExpect(jsonPath("$.name", is(elmut.getName())))
			.andExpect(jsonPath("$.money", is(elmut.getMoney())))
			.andExpect(jsonPath("$.password").doesNotExist());
	}
}
