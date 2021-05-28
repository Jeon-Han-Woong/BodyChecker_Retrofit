package org.ict.service;

import java.util.List;

import org.ict.domain.ExerciseVO;

public interface ExerciseService {
	
	public List<ExerciseVO> getAll(String edate, int mno);
	
	public Integer getEno();
	
	public Integer getSumKcal(String edate, int mno);
	
	public void regExer(ExerciseVO exer);
	
	public void modiExer(ExerciseVO exer);
	
	public void removeExer(int eno);

}
