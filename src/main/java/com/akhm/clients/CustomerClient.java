package com.akhm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.CustomerDTO;
import com.akhm.service.dto.UserDTO;

@FeignClient(url = "http://localhost:8010/")
public interface CustomerClient {
	@RequestMapping(method = RequestMethod.POST,value ="/registration" )
	public Integer saveCustomer(CustomerDTO customerDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/isCustomerExist")
	public boolean isCustomerExist(String emailId);
	@RequestMapping(method = RequestMethod.POST,value = "/login")
	public CustomerDTO getCustomer(CustomerDTO customerDTO);

}
