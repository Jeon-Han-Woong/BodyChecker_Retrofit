package org.ict.mapper;

import java.util.List;

import org.ict.domain.GoalVO;

public interface GoalMapper {
	
	// 진행중인 목표
	
	public List<GoalVO> getDoing(String fin_date);
	
	public Integer getNewGno();
	
	public void insertDoing(GoalVO goal);
	
	public void updateDoing(GoalVO goal);
	
	public void deleteDoing(int gno);
	
	// 종료된 목표
	
	public List<GoalVO> getFinish(String fin_date);

}
