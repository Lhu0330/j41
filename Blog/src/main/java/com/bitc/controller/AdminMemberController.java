package com.bitc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.service.AdminMemberService;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;
	
	@RequestMapping(value="/j41/adminMember" , method=RequestMethod.GET)
	public ModelAndView openAdminNotice(@RequestParam(required = false, defaultValue= "1") int p) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminMember");
		mv.addObject("AdminMemberList", new PageInfo<>(adminMemberService.selectAdminMember(p),10)); 
		return mv;
	}
	

}













