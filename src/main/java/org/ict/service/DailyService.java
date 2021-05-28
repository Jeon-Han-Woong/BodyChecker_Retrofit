package org.ict.service;

import org.ict.domain.DailyVO;

public interface DailyService {

	public void addDaily(DailyVO vo);
	
	public DailyVO getDaily(String date);
	
	public Integer getDailyWater(String ddate, int mno);
	
	public void plusWater(String ddate, int mno);
	
	public void minusWater(String ddate, int mno);
	
}
