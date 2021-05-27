package org.ict.mapper;

import java.util.List;

import org.ict.domain.ExerciseVO;

public interface ExerciseMapper {
	
	public List<ExerciseVO> getList(String edate);
	
	public Integer getEno();
	
	public Integer getSumKcal(String edate);
	
	public void insertExer(ExerciseVO exer);
	
	public void updateExer(ExerciseVO exer);
	
	public void deleteExer(int eno);

}
