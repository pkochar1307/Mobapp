package com.cg.mobshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mobshop.dto.Mobiles;
import com.cg.mobshop.service.MobileService;


@Controller
public class MobileController {
	
	@Autowired
	MobileService service;
	
	/*public MobileService getService()
	{
		return service;
	}
	
	public void setService(MobileService service){
		this.service=service;
	}
	*/
	
	@RequestMapping("getmoblist")
	public String showMobileList(Model model){
		List<Mobiles> list= service.getAllMobiles();
		model.addAttribute("list",list);
		
		
		return"Home";
	}
	
	@RequestMapping("GetUpdatePage")
	public String sendUpdatePage(@RequestParam("mobid")int mobId,Model model){
		Mobiles mobile=service.getMobileDetails(mobId);
		
		model.addAttribute("mobile", mobile);
		return"update";
	}
	
	@RequestMapping("Delete")
	public String deleteMobile(@RequestParam("mobid")int mobId,Model model){
		List<Mobiles> list= service.deleteMobile(mobId);
		model.addAttribute("list",list);
		model.addAttribute("msg", "mobile-record delted");
		
		return"Home";
	}
	
	@RequestMapping("updateMobileAction")
	public String updateMobile(@ModelAttribute("mobile")Mobiles mobile,Model model){
		
		service.updateMobile(mobile);
		List<Mobiles> list= service.getAllMobiles();
		model.addAttribute("list",list);
		
		return"Home";
	}
	
	


}
