package org.ict.mapper;

import org.ict.domain.DailyVO;

public interface DailyMapper {
	
	public void insert(DailyVO vo);
	
	public DailyVO select(String date);
	
	public void update(DailyVO vo);
	
}
