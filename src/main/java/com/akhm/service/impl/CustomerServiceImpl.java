package com.akhm.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.clients.CustomerClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.CustomerService;
import com.akhm.service.dto.AdminDTO;
import com.akhm.service.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CustomerClient customerClient;
	
	@Override
	public Integer insertCustomer(CustomerDTO customerDTO) {
		try {
			return customerClient.saveCustomer(customerDTO);
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}
	@Override
	public CustomerDTO getCustomer(CustomerDTO customerDTO) {
		try {
			
			return customerClient.getCustomer(customerDTO);
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}

	}
	@Override
	public boolean isCustomerExist(String emailId) {
		try {
			return customerClient.isCustomerExist(emailId);
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

}
