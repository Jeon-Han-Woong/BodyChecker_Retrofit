package org.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.MealVO;

public interface MealMapper {
	
	public List<MealVO> select(@Param("fdate")String fdate,@Param("mno") int mno);
	
	public void insert(MealVO vo);
	
	public void delete(@Param("fdate") String fdate, @Param("ftime") String ftime, @Param("mno") int mno);
	
}
