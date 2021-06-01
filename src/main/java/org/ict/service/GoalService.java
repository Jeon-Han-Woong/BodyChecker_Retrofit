package org.ict.service;

import java.util.List;

import org.ict.domain.GoalVO;

public interface GoalService {
	
	public List<GoalVO> getDoing(String fin_date, int mno);
	
	public Integer getNewGno();
	
	public void regDoing(GoalVO goal);
	
	public void modDoing(GoalVO goal);
	
	public void remGoal(int gno);
	
	public List<GoalVO> getFinish(String fin_date, int mno);
	
	public void selectSuccess(GoalVO goal);
	
	public int getTotal(int mno);
	
	public int getSuccessFinish(int mno);
	
	public GoalVO getDday(String fin_date, int mno);
	
}
