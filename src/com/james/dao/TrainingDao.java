package com.james.dao;

import com.james.entity.Training;

public interface TrainingDao {
	
	int addTraining(Training training);
	
	Training queryTrainingByDeptId(Integer deptId);
	
	
}
