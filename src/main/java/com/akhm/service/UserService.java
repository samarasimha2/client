package com.akhm.service;

import com.akhm.service.dto.UserDTO;

public interface UserService {
	public Integer insertUser(UserDTO userDTO);
	public UserDTO getUser(UserDTO userDTO);
	public boolean isUserExist(String emailId);
	

}
