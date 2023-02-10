package com.akhm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.UserDTO;

@FeignClient(url = "http://localhost:8095/")
public interface UserClient {
	@RequestMapping(method = RequestMethod.POST,value ="/registration" )
	public Integer saveUser(UserDTO userDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/isUserExist")
	public boolean isUserExist(String emailId);
	@RequestMapping(method = RequestMethod.POST,value = "/login")
	public UserDTO getUser(UserDTO userDTO);
	

}
