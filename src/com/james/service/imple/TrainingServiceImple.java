package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.TrainingDao;
import com.james.entity.Training;
import com.james.service.TrainingService;

@Service("trainService")
public class TrainingServiceImple implements TrainingService {
	
	@Autowired
	private TrainingDao trainDao;

	public int addTraining(Training training) {
		return trainDao.addTraining(training);
	}

	public int deleteTraining(Integer trainId) {
		return trainDao.deleteTraining(trainId);
	}

	public int updateTraining(Training training) {
		return trainDao.updateTraining(training);
	}


	public Training queryTrainingByDeptId(Integer deptId) {
		return trainDao.queryTrainingByDeptId(deptId);
	}

	public List<Training> queryAllTrainings() {
		return trainDao.queryAllTrainings();
	}

}
