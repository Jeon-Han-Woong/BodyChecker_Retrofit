package org.ict.service;

import java.util.List;

import org.ict.domain.ExerciseVO;
import org.ict.mapper.ExerciseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired ExerciseMapper mapper;
	
	@Override
	public List<ExerciseVO> getAll(String edate, int mno) {
		return mapper.getList(edate, mno);
	}
	
	@Override
	public Integer getEno() {
		return mapper.getEno();
	}
	
	@Override
	public Integer getSumKcal(String edate, int mno) {
		return mapper.getSumKcal(edate, mno);
	}

	@Override
	public void regExer(ExerciseVO exer) {
		mapper.insertExer(exer);
	}
	
	@Override
	public void modiExer(ExerciseVO exer) {
		mapper.updateExer(exer);
	}

	@Override
	public void removeExer(int eno) {
		mapper.deleteExer(eno);
	}

}
