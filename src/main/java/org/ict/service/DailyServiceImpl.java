package org.ict.service;

import org.ict.domain.DailyVO;
import org.ict.mapper.DailyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DailyServiceImpl implements DailyService {
	
	@Autowired
	private DailyMapper mapper;

	@Override
	public void addDaily(DailyVO vo) {
		mapper.insert(vo);
	}

	@Override
	public DailyVO getDaily(String date) {
		return mapper.select(date);
	}


	@Override
	public Integer getDailyWater(String ddate, int mno) {
		return mapper.getDailyWater(ddate, mno);
	}


	@Override
	public void plusWater(String ddate, int mno) {
		mapper.updateWater(+1, ddate, mno);
	}

	@Override
	public void minusWater(String ddate, int mno) {
		mapper.updateWater(-1, ddate, mno);
	}
	
	
}
