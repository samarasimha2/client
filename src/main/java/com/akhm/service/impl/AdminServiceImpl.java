package com.akhm.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.exception.MyClientCustomException;
import com.akhm.service.AdminService;
import com.akhm.service.dto.AdminDTO;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public AdminDTO getAdmin(String emailId, String password) {
		try {
			Map<String, String> admin=new LinkedHashMap<>();
			admin.put("emailId", emailId);
			admin.put("password", password);
			return restTemplate.postForObject("http://localhost:8001//admin/v0" ,admin, AdminDTO.class);
			
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
