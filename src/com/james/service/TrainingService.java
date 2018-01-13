package com.james.service;

import java.util.List;

import com.james.entity.Training;

public interface TrainingService {

	int addTraining(Training training);
	
	int deleteTraining(Integer trainId);
	
	int updateTraining(Training training);
	
	Training queryTrainingByDeptId(Integer deptId);
	
	List<Training> queryAllTrainings();
}
