package com.james.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.dao.BonusmalusDao;
import com.james.entity.Bonusmalus;
import com.james.service.BonusmalusService;

@Service("bmService")
public class BonusmalusServiceImple implements BonusmalusService {
	
	@Autowired
	private BonusmalusDao bmDao;

	public int insertBM(Bonusmalus bm) {
		return bmDao.addBonusmalus(bm);
	}

	public List<Bonusmalus> queryBMsbyUserId(Integer userId) {
		return bmDao.queryBMsbyUserId(userId);
	}

	public List<Bonusmalus> queryBMsByUserIdAndDate(Integer userId, int bYear, int bMonth) {
		return bmDao.queryBMsByUserIdAndDate(userId, bYear, bMonth);
	}


	public List<Bonusmalus> queryBMsByDate(int bYear, int bMonth) {
		return bmDao.queryBMsByDate(bYear, bMonth);
	}

}
