package com.akhm.service;

import com.akhm.service.dto.CustomerDTO;


public interface CustomerService {
	public Integer insertCustomer(CustomerDTO customerDTO);
	public CustomerDTO getCustomer(CustomerDTO customerDTO);
	public boolean isCustomerExist(String emailId);

}
