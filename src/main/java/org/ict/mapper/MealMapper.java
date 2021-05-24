package org.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.MealVO;

public interface MealMapper {
	
	public List<MealVO> select(String fdate);
	
	public void insert(MealVO vo);
	
	public void delete(@Param("fdate") String fdate, @Param("ftime") String ftime);
	
}
