package org.ict.mapper;

import java.util.List;

import org.ict.domain.GoalVO;

public interface GoalMapper {
	
	public List<GoalVO> getDoing(String fin_date);
	
	public Integer getNewGno();
	
	public void insertDoing(GoalVO goal);
	
	public void updateDoing(GoalVO goal);
	
	public void deleteDoing(int gno);

}
