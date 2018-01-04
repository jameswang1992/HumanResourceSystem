package com.james.dao;

import java.util.List;

import com.james.entity.Position;

public interface PositionDao {
	
	int addPosition(Position position);
	
	int deletePosition(Integer positionId);
	
	int updatePosition(Position position);
	
	/**
	 * ���ݲ���ID��ѯ�����������Щְλ
	 * @param deptId
	 * @return
	 */
	List<Position> queryPositionsByDeptId(Integer deptId);
	
	Position queryPositionByPositionId(Integer positionId);
	
	
	
}
