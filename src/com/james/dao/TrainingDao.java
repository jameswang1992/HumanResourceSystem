package com.james.dao;

import java.util.List;

import com.james.entity.Training;

public interface TrainingDao {
	
	int addTraining(Training training);
	
	int deleteTraining(Integer trainId);
	
	int updateTraining(Training training);
	
	Training queryTrainingByDeptId(Integer deptId);
	
	List<Training> queryAllTrainings();
}
