package com.sp.rest;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sp.model.User;
import com.sp.service.UserService;

@RestController
public class UserCrt {
	@Autowired
	UserService uService;

	@RequestMapping(method = RequestMethod.POST, value = "/login", headers = "Content-Type=application/x-www-form-urlencoded")
	@ResponseStatus(HttpStatus.OK)
	public void login(@RequestParam String username, @RequestParam String password, HttpServletResponse response)
			throws IOException {
		Integer userId = uService.login(username, password);
		response.addCookie(new Cookie("userId", userId.toString()));
		response.sendRedirect("/cardHome.html");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public Iterable<User> getUsers() {
		return uService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public User getUser(@PathVariable String id) {
		return uService.getUser(Integer.valueOf(id));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/current")
	public User getUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null || cookies.length != 1 ) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		Cookie cookie = cookies[0];
		return uService.getUser(Integer.valueOf(cookie.getValue()));
	}
	
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		uService.addUser(user);
	}

}
