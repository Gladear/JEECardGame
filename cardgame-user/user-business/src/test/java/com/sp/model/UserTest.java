package com.sp.model;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {
	
	@Test
	public void createUser() {
		User user = new User(1, "User", "password", 100);
		assertTrue(user.getId() == 1);
		assertTrue(user.getName() == "User");
		assertTrue(user.getPassword() == "password");
		assertTrue(user.getMoney() == 100);
	}
}
