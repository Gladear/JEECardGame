package com.sp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class RequestUtils {
	private RequestUtils() {
	}

	public static Integer getUserID(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies.length != 1) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		Cookie cookie = cookies[0];

		try {
			return Integer.valueOf(cookie.getValue());
		} catch (NumberFormatException ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}
}
