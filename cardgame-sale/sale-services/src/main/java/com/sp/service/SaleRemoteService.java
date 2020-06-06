package com.sp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaleRemoteService {
	private static final String SERVICE_URL = "http://localhost:8082/";

	private final RestTemplate restTemplate = new RestTemplate();
}
