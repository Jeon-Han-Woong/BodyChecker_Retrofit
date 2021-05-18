package org.ict.service;

import org.ict.domain.DailyVO;

public interface DailyService {

	public void addDaily(DailyVO vo);
	
	public DailyVO getDaily(String date);
	
	public void modifyDaily(DailyVO vo);
	
}
