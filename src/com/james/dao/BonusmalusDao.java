package com.james.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.james.entity.Bonusmalus;

public interface BonusmalusDao {
	
	int addBonusmalus(Bonusmalus bm);
	
	List<Bonusmalus> queryBMsByDate(@Param(value = "bYear")int bYear,@Param(value = "bMonth")int bMonth);
	
	List<Bonusmalus> queryBMsbyUserId(Integer userId);
}
