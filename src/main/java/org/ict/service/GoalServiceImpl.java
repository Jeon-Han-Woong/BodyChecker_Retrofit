package org.ict.service;

import java.util.List;

import org.ict.domain.GoalVO;
import org.ict.mapper.GoalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService{

	@Autowired
	private GoalMapper mapper;
	
	@Override
	public List<GoalVO> getDoing(String fin_date) {
		return mapper.getDoing(fin_date);
	}
	
	@Override
	public Integer getNewGno() {
		return mapper.getNewGno();
	}

	@Override
	public void regDoing(GoalVO goal) {
		mapper.insertDoing(goal);
	}

	@Override
	public void modDoing(GoalVO goal) {
		mapper.updateDoing(goal);
	}

	@Override
	public void remDoing(int gno) {
		mapper.deleteDoing(gno);
	}

	

}
