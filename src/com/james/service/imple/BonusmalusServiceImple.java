package com.james.service.imple;

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

}
