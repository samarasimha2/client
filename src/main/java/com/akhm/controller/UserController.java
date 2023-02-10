package com.akhm.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.controller.command.UserCommand;
import com.akhm.service.UserService;
import com.akhm.service.dto.AdminDTO;
import com.akhm.service.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(name = "/userLogin",method = RequestMethod.GET)
	public String showUserLogin()
	{
		return "userLogin";
	}
	@PostMapping("userLogin")
	public String submitUserLogin(HttpServletRequest request,@RequestBody UserDTO userDTO)
	{
		UserDTO user=userService.getUser(userDTO);
		if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("AUTH_USER", userDTO);
			return "redirect:userHome";
		}
		else {
			request.setAttribute("errorMessege", "invalid emailId or Password");
		}
		
		return "userLogin";
	}
	@GetMapping("/userRegistration")
	public String showRegistration()
	{
		return "userRegistration";
	}
	@PostMapping("userRegistration")
	public String submitRegistration(HttpServletRequest request,UserDTO userDTO)
	{
		Integer userId=userService.insertUser(userDTO);
		if(userId!=null)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("AUTH_USER", userDTO);
			return "redirect:userHome";
		}
		else
		{
			request.setAttribute("errorMessege", "invalid userName are register");
		}
		return "userRegistration";
	}

}
