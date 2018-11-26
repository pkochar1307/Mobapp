package com.cg.mobshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mobshop.dao.MobileDao;
import com.cg.mobshop.dto.Mobiles;

@Service("service")
@Transactional

public class MobileServiceImpl implements MobileService {
	
	@Autowired
	MobileDao dao;
	

	@Override
	public List<Mobiles> getAllMobiles() {
		// TODO Auto-generated method stub
		return dao.getAllMobiles();
	}


	@Override
	public Mobiles getMobileDetails(int mobId) {
		// TODO Auto-generated method stub
		return dao.getMobileDetails(mobId);
	}


	@Override
	public int updateMobile(Mobiles mob) {
		// TODO Auto-generated method stub
		return dao.updateMobile(mob);
	}


	@Override
	public List<Mobiles> deleteMobile(int mobId) {
		// TODO Auto-generated method stub
		return dao.deleteMobile(mobId);
	}


	
	
	
	

}
