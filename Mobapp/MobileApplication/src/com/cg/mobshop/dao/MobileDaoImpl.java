package com.cg.mobshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.mobshop.dto.Mobiles;
@Repository("dao")
public class MobileDaoImpl  implements MobileDao{

	
	@PersistenceContext
	EntityManager manager;
	
	/*public EntityManager getManager(){
		return manager;
	}
	
	public void setManager(EntityManager manager){
		this.manager=manager;
	}*/
	
	@Override
	public List<Mobiles> getAllMobiles() {
		// TODO Auto-generated method stub
		String str="Select mobile from Mobiles mobile";
		TypedQuery<Mobiles> query=manager.createQuery(str,Mobiles.class);
		return query.getResultList();
	}

	@Override
	public Mobiles getMobileDetails(int mobId) {
		// TODO Auto-generated method stub
		Mobiles mobile=manager.find(Mobiles.class, mobId);
		return mobile;
	}

	@Override
	public int updateMobile(Mobiles mob) {
		// TODO Auto-generated method stub
		manager.merge(mob);
		return mob.getMobileId();
	}

	@Override
	public List<Mobiles> deleteMobile(int mobId) {
		// TODO Auto-generated method stub
		Mobiles mobile=getMobileDetails(mobId);
		manager.remove(mobile);
		return getAllMobiles();
	}

	
}
