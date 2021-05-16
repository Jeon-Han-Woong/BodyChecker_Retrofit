package org.ict.service;

import java.util.List;

import org.ict.domain.ExerciseVO;

public interface ExerciseService {
	
	public List<ExerciseVO> getAll(String edate);
	
	public void regExer(ExerciseVO exer);
	
	public void modiExer(ExerciseVO exer);
	
	public void removeExer(int eno);

}
