package org.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.ExerciseVO;

public interface ExerciseMapper {
	
	public List<ExerciseVO> getList(@Param("edate") String edate, @Param("mno") int mno);
	
	public Integer getEno();
	
	public Integer getSumKcal(@Param("edate") String edate, @Param("mno") int mno);
	
	public void insertExer(ExerciseVO exer);
	
	public void updateExer(ExerciseVO exer);
	
	public void deleteExer(int eno);

}
