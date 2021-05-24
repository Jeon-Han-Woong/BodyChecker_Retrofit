package org.ict.service;

import java.util.List;

import org.ict.domain.MealVO;
import org.ict.mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealMapper mapper;
	
	@Override
	public List<MealVO> getFoods(String fdate) {
		return mapper.select(fdate);
	}

	@Override
	public void addFoods(MealVO vo) {
		mapper.insert(vo);
	}

	@Override
	public void removeFoods(String fdate, String ftime) {
		mapper.delete(fdate, ftime);
	}

}
