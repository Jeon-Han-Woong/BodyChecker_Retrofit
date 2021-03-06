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
	public List<GoalVO> getDoing(String fin_date, int mno) {
		return mapper.getDoing(fin_date, mno);
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
	public void remGoal(int gno) {
		mapper.deleteGoal(gno);
	}

	@Override
	public List<GoalVO> getFinish(String fin_date, int mno) {
		return mapper.getFinish(fin_date, mno);
	}

	@Override
	public void selectSuccess(GoalVO goal) {
		mapper.selectSuccess(goal);
	}

	@Override
	public int getSuccessFinish(int mno) {
		return mapper.getSuccessFinish(mno);
	}

	@Override
	public int getTotal(int mno) {
		return mapper.getTotal(mno);
	}

	@Override
	public GoalVO getDday(String fin_date, int mno) {
		return mapper.getDday(fin_date, mno);
	}

}
