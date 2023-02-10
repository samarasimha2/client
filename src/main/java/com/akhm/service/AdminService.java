package com.akhm.service;

import org.springframework.stereotype.Service;

import com.akhm.service.dto.AdminDTO;

@Service
public interface AdminService {
	public AdminDTO getAdmin(String emailId,String password);
	

}
