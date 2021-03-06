package org.ict.service;

import org.ict.domain.DailyVO;

public interface DailyService {

	public void addDaily(DailyVO vo);
	
	public DailyVO getDaily(String date);
	
	public Integer getDailyWater(String ddate, int mno);
	
	public Integer plusWater(String ddate, int mno);
	
	public Integer minusWater(String ddate, int mno);

    public Integer getWalk(String ddate, int mno);
    
    public void addWalk(String ddate, int mno);
    
}
