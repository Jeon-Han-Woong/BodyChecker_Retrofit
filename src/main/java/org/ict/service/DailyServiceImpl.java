package org.ict.service;

import org.ict.domain.DailyVO;
import org.ict.mapper.DailyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void modifyDaily(DailyVO vo) {
		mapper.update(vo);
	}
	
}
