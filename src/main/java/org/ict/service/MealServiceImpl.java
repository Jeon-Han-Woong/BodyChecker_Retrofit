package org.ict.service;

import java.sql.Date;
import java.util.List;

import org.ict.domain.MealVO;
import org.ict.mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealMapper mapper;
	
	@Override
	public List<MealVO> getFoods(Date date) {
		return mapper.select(date);
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
