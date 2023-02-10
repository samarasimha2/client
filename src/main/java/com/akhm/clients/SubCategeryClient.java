package com.akhm.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.SubCategeryDTO;

@FeignClient(url = "http://localhost:8010/")
public interface SubCategeryClient {
	@RequestMapping(method = RequestMethod.POST,value = "/subCategery/save")
	public Integer insertSubCategery(SubCategeryDTO subCategeryDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/subCategery/get")
	public List<SubCategeryDTO> getSubCategeries();
	@RequestMapping(method = RequestMethod.GET,value = "/subCategery/get/{subCategeryId}")
	public SubCategeryDTO getSubCategery(Integer subCategeryId);
	@RequestMapping(method = RequestMethod.POST,value = "/subCategery/update")
	public void updateSubCategery(SubCategeryDTO subCategeryDTO);

}
