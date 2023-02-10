package com.akhm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.apache.commons.configuration.SubnodeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.controller.command.AdminCommand;
import com.akhm.controller.command.CategeryCommand;
import com.akhm.controller.command.SubCategeryCommand;
import com.akhm.service.AdminService;
import com.akhm.service.CategeryService;
import com.akhm.service.SubCategeryService;
import com.akhm.service.dto.AdminDTO;
import com.akhm.service.dto.CategeryDTO;
import com.akhm.service.dto.SubCategeryDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CategeryService categeryService;
	@Autowired
	private SubCategeryService subCategeryService;
	@RequestMapping(name = "/adminLogin",method = RequestMethod.GET)
	public String showAdminLogin()
	{
		return "adminLogin";
	}
	@RequestMapping(name = "/adminLogin",method = RequestMethod.POST)
	public String submitAdminLogin(HttpServletRequest request,AdminCommand adminCommand)
	{
		
		AdminDTO adminDTO=adminService.getAdmin(adminCommand.getEmailId(), adminCommand.getPassword());
		if(adminDTO!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("AUTH_ADMIN", adminDTO);
			return "redirect:adminHome";
		}
		else {
			request.setAttribute("errorMessege", "invalid emailId or Password");
		}
		
		
		return "adminLogin"	;
	}
	@GetMapping("/adminHome")
	public String adminhome(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				return "adminHome";
			}
		
		}
		return "redirect:adminHome";
		
	}
	@GetMapping("/addCategery")
	public String showAddCategery(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				return "addCategery";
			}
		
		}
		return "redirect:adminHome";
		
	}
	@PostMapping("/addCategery")
	public String submitAddCategery(HttpServletRequest request,CategeryCommand categeryCommand)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				CategeryDTO categeryDTO=new CategeryDTO();
				categeryDTO.setCategeryName(categeryCommand.getCategeryName());
				categeryDTO.setCategeryDescription(categeryCommand.getCategeryDescription());
				categeryDTO.setCategeryCode(categeryCommand.getCategeryCode());
				Integer categeryId=categeryService.insertCategery(categeryDTO);
				if(categeryId!=null&&categeryId>0)
				{
					return "redirect:categeries";
				}
				else {
					return "addCategry";
				}
				
			}
		
		}
		return "redirect:adminHome";
		
	}
	@GetMapping("/addSubCategery")
	public String showAddSubCategery(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				return "addSubCategery";
			}
		
		}
		return "redirect:adminHome";
		
	}
	@PostMapping("/addSubCategery")
	public String submitAddSubCategery(HttpServletRequest request,SubCategeryCommand subCategeryCommand)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				SubCategeryDTO subCategeryDTO=new SubCategeryDTO();
				subCategeryDTO.setSubCategeryName(subCategeryCommand.getSubCategeryName());
				subCategeryDTO.setSubCategeryDescription(subCategeryCommand.getSubCategeryDescription());
				subCategeryDTO.setSubCategeryCode(subCategeryCommand.getSubCategeryCode());
				Integer subCategeryId=subCategeryService.insertSubCategery(subCategeryDTO);
				if(subCategeryId!=null&&subCategeryId>0)
				{
					return "redirect:subCategeries";
				}
				else {
					return "addCategry";
				}
				
			}
		
		}
		return "redirect:adminHome";
		
	}
	@GetMapping("/categeries")
	public String showCategeries(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				List<CategeryDTO> categeries=categeryService.getCategeries();
				request.setAttribute("categeries", categeries);
				return "adminCategeries";//jsp name
			}
		
		}
		return "redirect:adminHome";
		
	}
	public String showSubCategeries(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			AdminDTO adminDTO=(AdminDTO) session.getAttribute("AUTH_ADMIN");
			if(adminDTO!=null)
			{
				List<SubCategeryDTO> subCategeries=subCategeryService.getSubCategeries();
				request.setAttribute("subCategeries", subCategeries);
				return "adminSubCategeries";//jsp name
			}
		
		}
		return "redirect:adminHome";
		
	}



	

}
