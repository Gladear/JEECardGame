package com.sp.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class RequestUtils {
	private RequestUtils() {
	}

	public static Integer getUserID(HttpServletRequest request) {
		String userId = request.getHeader("Authenticate");

		try {
			return Integer.valueOf(userId);
		} catch (NumberFormatException ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}
}
