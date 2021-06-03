package org.ict.mapper;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.DailyVO;

public interface DailyMapper {
	
	public void insert(DailyVO vo);
	
	public DailyVO select(String date);
	
	public Integer getDailyWater(@Param("ddate") String ddate, @Param("mno") int mno);
	
	public void updateWater(@Param("amount") int amount, @Param("ddate") String ddate, @Param("mno") int mno);
	
	public Integer getWalk(@Param("ddate") String ddate, @Param("mno") int mno);
	
	public void addWalk(@Param("ddate") String ddate, @Param("mno") int mno, @Param("amount") int amount);
	
}
