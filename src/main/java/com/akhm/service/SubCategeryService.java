package com.akhm.service;

import java.util.List;

import com.akhm.service.dto.CategeryDTO;
import com.akhm.service.dto.SubCategeryDTO;

public interface SubCategeryService {
	public Integer insertSubCategery(SubCategeryDTO subCategeryDTO);
	public List<SubCategeryDTO> getSubCategeries();
	public SubCategeryDTO getSubCategery(Integer subCategeryId);
	public void updateSubCategery(SubCategeryDTO subCategeryDTO);

}
