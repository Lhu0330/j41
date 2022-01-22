package com.bitc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.CustomerDto;
import com.bitc.dto.OrderDetailDto;
import com.bitc.dto.OrdersDto;
import com.bitc.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	public CustomerService customerService;
	
	// 테스트 페이지
//	@RequestMapping("/")
//	public String test() throws Exception {
//		return "/index";
//	}
	
	// 회원가입 페이지
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String openRegister() throws Exception {
		return "/register";
	}
	
	// ID 중복 확인
	@ResponseBody
	@RequestMapping(value="/register/idcheck", method=RequestMethod.GET)
	public String idCheck(String customerId) throws Exception {
		CustomerDto customer = customerService.idCheck(customerId);
		if(customer == null) {
			return "{\"check\":\"true\"}";
		} else {
			return "{\"check\":\"false\"}";
		}
	}
	
	// 닉네임 중복 확인
	@ResponseBody
	@RequestMapping(value="/register/nicknamecheck", method=RequestMethod.GET)
	public String nickNameCheck(String customerNickName) throws Exception {
		CustomerDto customer = customerService.nickNameCheck(customerNickName);
		if(customer == null) {
			return "{\"check\":\"true\"}";
		} else {
			return "{\"check\":\"false\"}";
		}
	}
	
	// 회원 추가
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String insertCustomer(CustomerDto customer) throws Exception {
		customerService.insertCustomer(customer);
		return "/registerOK";
	}
	
	// 로그인 페이지
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String openLogin() throws Exception {
		return "/login";
	}
	
	// 로그인 정보 확인 + 고객정보 가져오기
	@RequestMapping(value="/login/check", method=RequestMethod.POST)
	public String loginCheck(CustomerDto customer, HttpServletRequest request) throws Exception {
		int count = customerService.selectCustomerInfoYn(customer.getCustomerId(), customer.getCustomerPw());
		
		if (count == 1) {
			HttpSession session = request.getSession();
			customer = customerService.bringCustomerInfo(customer.getCustomerId());
			
			session.setAttribute("customerId", customer.getCustomerId());
			session.setAttribute("customerIdx", customer.getCustomerIdx());
			session.setMaxInactiveInterval(30);
			return "redirect:/login/mypage";
		} else {
			return "redirect:/login/loginfail";
		}
	}
	
	// 마이페이지+주문목록
	@RequestMapping(value="/login/mypage", method=RequestMethod.GET)
	public ModelAndView openMyPage(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/myPage");
		HttpSession session = request.getSession();
		int customerIdx = (int)session.getAttribute("customerIdx");
		List<OrdersDto> orders = customerService.selectOrderList(customerIdx);
		mv.addObject("orders", orders);
		return mv;
	}
	
	// 주문 자세히 보기
	@RequestMapping(value="/login/personalorderdetail/{orderIdx}", method=RequestMethod.GET)
	public ModelAndView openPersonalOrderDetail(@PathVariable("orderIdx") int orderIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/personalOrderDetail");
		List<OrderDetailDto> orderDetail = customerService.selectPODList(orderIdx);
		mv.addObject("orderDetail", orderDetail);
		return mv;
	}
	
	
	// 로그인 실패
	@RequestMapping(value="/login/loginfail", method=RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/loginFail";
	}
	
	// 로그아웃
	@RequestMapping(value="/login/logout", method=RequestMethod.GET)
	public String logOut(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("customerId");
		session.removeAttribute("customerIdx");
		session.invalidate();
		return "/logout";
	}
	
	
	// 회원 정보 수정 페이지
	@RequestMapping(value="/login/mypage/detail/{customerId}", method=RequestMethod.GET)
	public ModelAndView openMyPageDetail(@PathVariable("customerId") String customerId) throws Exception {
		ModelAndView mv = new ModelAndView("/myPageDetail");
		CustomerDto customer = customerService.selectCustomerDetail(customerId);
		mv.addObject("customer", customer);
		return mv;
	}
	
	// 회원 정보 수정
	@RequestMapping(value="/login/mypage/detail/edit/{customerId}", method=RequestMethod.PUT)
	public String editMyPageDetail(CustomerDto customer) throws Exception {
		customerService.editCustomerDetail(customer);
		return "redirect:/login/mypage";
	}
	
	// 회원 탈퇴
	@RequestMapping(value="/login/mypage/detail/delete/{customerId}", method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable("customerId") String customerId) throws Exception {
		customerService.deleteAccount(customerId);
		return "/afterDeleteAccount";
	}
	
	// 잘못된 접근 페이지
	@RequestMapping(value="/login/somethingwrong", method=RequestMethod.GET)
	public String somethingWrong() throws Exception {
		return "/somethingWrong";
	}
	
	// 리뷰 작성 페이지 (우선 순위 아님)
	
	// 리뷰 추가 (우선 순위 아님)
	
	// 리뷰 파일..? (우선 순위 아님)
}
