package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.PositionDao;
import com.james.entity.Position;
import com.james.service.PositionService;

@Service("position")
public class PositionServiceImple implements PositionService {

	@Autowired
	private PositionDao posDao;
	
	public List<Position> queryPositionsByDeptId(Integer deptId) {
		return posDao.queryPositionsByDeptId(deptId);
	}

	public Position queryPositionByPositionId(Integer positionId) {
		return posDao.queryPositionByPositionId(positionId);
	}

	public int insertPosition(Position position) {
		return posDao.addPosition(position);
	}


	public int updatePosition(Position position) {
		return posDao.updatePosition(position);
	}

	public int deletePosition(Integer positionId) {
		return posDao.deletePosition(positionId);
	}

}
