package com.akhm.service;

import java.util.List;


import com.akhm.service.dto.CategeryDTO;

public interface CategeryService {
	public Integer insertCategery(CategeryDTO categeryDTO);
	public List<CategeryDTO> getCategeries();
	public CategeryDTO getCategery(Integer categeryId);
	public void updateCategery(CategeryDTO categeryDTO);

}
