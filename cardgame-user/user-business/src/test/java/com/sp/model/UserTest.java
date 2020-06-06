package com.sp.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
public class UserTest {

	@Test
	public void createUser() {
		double money = 100;
		User user = new User(1, "User", "password", money);
		assertTrue(user.getId() == 1);
		assertTrue(user.getName().equals("User"));
		assertTrue(user.getPassword().equals("password"));
		assertTrue(user.getMoney() == money);
	}
}
