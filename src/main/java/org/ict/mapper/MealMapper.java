package org.ict.mapper;

import java.sql.Date;
import java.util.List;

import org.ict.domain.MealVO;

public interface MealMapper {
	
	public List<MealVO> select(Date date);
	
	public void insert(MealVO vo);
	
	public void delete(String ftime);
	
}
