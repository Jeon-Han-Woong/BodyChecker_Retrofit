package org.ict.service;

import java.util.List;

import org.ict.domain.MealVO;

public interface MealService {
	
	public List<MealVO> getFoods(String fdate);
	
	public void addFoods(MealVO vo);
	
	public void removeFoods(String fdate, String ftime);
	
}
