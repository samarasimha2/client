package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.clients.CategeryClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.CategeryService;
import com.akhm.service.dto.CategeryDTO;

@Service
public class CategeryServiceImpl implements CategeryService{
	@Autowired
	private CategeryClient categeryClient;

	@Override
	public Integer insertCategery(CategeryDTO categeryDTO) {
		try {
			return categeryClient.insertCategery(categeryDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public List<CategeryDTO> getCategeries() {
		try {
			return categeryClient.getCategeries();
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public CategeryDTO getCategery(Integer categeryId) {
		try {
			return categeryClient.getCategery(categeryId);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public void updateCategery(CategeryDTO categeryDTO) {
		try {
			categeryClient.updateCategery(categeryDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
