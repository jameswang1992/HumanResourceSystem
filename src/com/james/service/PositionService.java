package com.james.service;

import java.util.List;

import com.james.entity.Position;

public interface PositionService {
	
	List<Position> queryPositionsByDeptId(Integer deptId);
	
	Position queryPositionByPositionId(Integer positionId);
}
