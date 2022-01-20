package com.bitc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired
	
	@RequestMapping("/jr41/adminMain")
	public String adminMain() throws Exception {
		return "/admin/AdminMain";
	}
	

}













