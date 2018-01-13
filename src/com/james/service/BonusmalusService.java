package com.james.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.james.entity.Bonusmalus;

public interface BonusmalusService {
	
	int insertBM(Bonusmalus bm);
	
	List<Bonusmalus> queryBMsbyUserId(Integer userId);
	
	List<Bonusmalus> queryBMsByUserIdAndDate(@Param(value = "userId")Integer userId,@Param(value = "bYear")int bYear,@Param(value = "bMonth")int bMonth);
	
	List<Bonusmalus> queryBMsByDate(@Param(value = "bYear")int bYear,@Param(value = "bMonth")int bMonth);
}
