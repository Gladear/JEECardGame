package com.sp.repository;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findUser() {
		Optional<User> optCard = userRepository.findById(1);
		assertTrue(optCard.isPresent());
		assertTrue(optCard.get().getId().equals(1));
	}
	@Test
	public void createUser() {
			double money = 100;
			User testUser = new User(1, "john", "123456", money);
			userRepository.save(testUser);
			Optional<User> optUser = userRepository.findById(1);
			assertTrue(optUser.isPresent());
			assertTrue(optUser.get().getId().equals(1));
			assertTrue(optUser.get().getName().equals("john"));
			assertTrue(optUser.get().getPassword().equals("123456"));
			assertTrue(optUser.get().getMoney().equals(money));
	}
	
	@Test
	public void updateUser() {
		double money = 100;
		User testUser = new User(1, "john", "123456", money);
		userRepository.save(testUser);
		testUser.setPassword("1234567");
		userRepository.save(testUser);
		Optional<User> optUser = userRepository.findById(1);
		assertTrue(optUser.isPresent());
		assertTrue(optUser.get().getId().equals(1));
		assertTrue(optUser.get().getName().equals("john"));
		assertTrue(optUser.get().getPassword().equals("1234567"));
		assertTrue(optUser.get().getMoney().equals(money));
		
	}
	
	@Test
	public void deleteUser() {
		double money = 100;
		User testUser = new User(1, "john", "123456", money);
		userRepository.save(testUser);
		Optional<User> optUser = userRepository.findById(1);
		assertTrue(optUser.isPresent());
		userRepository.delete(testUser);
		optUser = userRepository.findById(1);
		assertTrue(!optUser.isPresent());
	}
}
