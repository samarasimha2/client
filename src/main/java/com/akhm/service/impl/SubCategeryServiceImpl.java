package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.akhm.clients.SubCategeryClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.SubCategeryService;
import com.akhm.service.dto.SubCategeryDTO;

public class SubCategeryServiceImpl implements SubCategeryService{
	@Autowired
	private SubCategeryClient subCategeryClient;

	@Override
	public Integer insertSubCategery(SubCategeryDTO subCategeryDTO) {
		try {
			return subCategeryClient.insertSubCategery(subCategeryDTO);
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public List<SubCategeryDTO> getSubCategeries() {
		try {
			return subCategeryClient.getSubCategeries();
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public SubCategeryDTO getSubCategery(Integer subCategeryId) {
		try {
			return subCategeryClient.getSubCategery(subCategeryId);
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public void updateSubCategery(SubCategeryDTO subCategeryDTO) {
		try {
			subCategeryClient.updateSubCategery(subCategeryDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
