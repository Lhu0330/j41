package com.bitc.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.AdminMemberDto;
import com.bitc.dto.JDto;
import com.bitc.service.AdminMemberService;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;
	
	@RequestMapping(value="/jr41/adminMember" , method=RequestMethod.GET)
	public ModelAndView openAdminNotice(@RequestParam(required = false, defaultValue= "1") int p) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminMember");
		mv.addObject("AdminMemberList", new PageInfo<>(adminMemberService.selectAdminMember(p),10)); 
		return mv;
	}
	
	@RequestMapping(value="/jr41/adminMemberDetail/{customerIdx}", method=RequestMethod.GET)
	public ModelAndView selectAdminNoticeDetail(@PathVariable("customerIdx") int customerIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminMemberDetail");
			
		AdminMemberDto AdminMember = adminMemberService.selectAdminMemberDetail(customerIdx);
		mv.addObject("AdminMemberList", AdminMember);
		
		return mv;
	}
	
	@RequestMapping(value="/jr41/adminMemberHistory/{customerIdx}", method=RequestMethod.GET)
	public ModelAndView historypage(@PathVariable("customerIdx") int customerIdx, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminMemberHistory");
		HttpSession session = request.getSession();
		String ads = (String) session.getAttribute("customerAdminStore");
		List<JDto> successList = adminMemberService.selectMemberList(customerIdx, ads);
		mv.addObject("successList", successList);
		return mv;
	}

}













