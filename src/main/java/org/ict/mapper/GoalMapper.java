package org.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.GoalVO;

public interface GoalMapper {
	
	// 진행중인 목표
	
	public List<GoalVO> getDoing(@Param("fin_date") String fin_date, @Param("mno") int mno);
	
	public Integer getNewGno();
	
	public void insertDoing(GoalVO goal);
	
	public void updateDoing(GoalVO goal);
	
	public void deleteGoal(int gno);
	
	// 종료된 목표
	
	public List<GoalVO> getFinish(@Param("fin_date") String fin_date, @Param("mno") int mno);
	
	public void selectSuccess(GoalVO goal);
	
	public int getTotal(int mno);

	public int getSuccessFinish(int mno);
	
}
