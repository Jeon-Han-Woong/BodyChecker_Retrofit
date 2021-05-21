package org.ict.service;

import java.sql.Date;
import java.util.List;

import org.ict.domain.MealVO;

public interface MealService {
	
	public List<MealVO> getFoods(Date date);
	
	public void addFoods(MealVO vo);
	
	public void removeFoods(MealVO vo);
	
}
