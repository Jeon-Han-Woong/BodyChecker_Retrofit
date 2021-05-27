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
	public List<ExerciseVO> getAll(String edate) {
		return mapper.getList(edate);
	}
	
	@Override
	public Integer getEno() {
		return mapper.getEno();
	}
	
	@Override
	public Integer getSumKcal(String edate) {
		return mapper.getSumKcal(edate);
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
