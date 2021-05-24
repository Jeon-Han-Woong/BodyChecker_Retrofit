package org.ict.service;

import java.util.List;

import org.ict.domain.GoalVO;

public interface GoalService {
	
	public List<GoalVO> getDoing(String fin_date);
	
	public Integer getNewGno();
	
	public void regDoing(GoalVO goal);
	
	public void modDoing(GoalVO goal);
	
	public void remDoing(int gno);

}
