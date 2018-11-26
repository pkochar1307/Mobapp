package com.cg.mobshop.service;

import java.util.List;

import com.cg.mobshop.dto.Mobiles;

public interface MobileService {
	
	public List<Mobiles> getAllMobiles();
	public Mobiles getMobileDetails(int mobId);
	public int updateMobile(Mobiles mob);
	public List<Mobiles >deleteMobile(int mobId);

}
