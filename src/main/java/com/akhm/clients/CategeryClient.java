package com.akhm.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.CategeryDTO;
@FeignClient(url = "http://localhost:8001/")
public interface CategeryClient {
	@RequestMapping(method = RequestMethod.POST,value = "/categery/save")
	public Integer insertCategery(CategeryDTO categeryDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/categery/get")
	public List<CategeryDTO> getCategeries();
	@RequestMapping(method = RequestMethod.GET,value = "/categery/get/{categeryId}")
	public CategeryDTO getCategery(Integer categeryId);
	@RequestMapping(method = RequestMethod.POST,value = "/categery/update")
	public void updateCategery(CategeryDTO categeryDTO);
}
