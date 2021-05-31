package org.ict.service;

import java.util.List;

import org.ict.domain.GoalVO;

public interface GoalService {
	
	public List<GoalVO> getDoing(String fin_date);
	
	public Integer getNewGno();
	
	public void regDoing(GoalVO goal);
	
	public void modDoing(GoalVO goal);
	
	public void remGoal(int gno);
	
	public List<GoalVO> getFinish(String fin_date);
	
	public void selectSuccess(GoalVO goal);
	
	public int getTotal();
	
	public int getSuccessFinish();
	
}
