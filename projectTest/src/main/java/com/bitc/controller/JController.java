package com.bitc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.JDto;
import com.bitc.service.JService;

@Controller
public class JController {

	@Autowired
	private JService jService;

	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping("/cart.do")
	public ModelAndView cartList() throws Exception {
		ModelAndView mv = new ModelAndView("/cart/cartList");
		List<JDto> cartList = jService.selectCartList();
		mv.addObject("cartList", cartList);
		return mv;
	}

	@RequestMapping("/cart/order.do")
	public ModelAndView orderpage(JDto cart) throws Exception {
		ModelAndView mv = new ModelAndView("/cart/order");
		List<JDto> cartList = jService.selectCartList();
		mv.addObject("cartList", cartList);
		
		JDto cartsum = jService.selectCostCalculate(cart);
		mv.addObject("cartsum", cartsum);
		return mv;
	}

	@RequestMapping("/cart/delete.do")
	public String cartdelete(@RequestParam("productIdx") int productIdx) throws Exception {
		jService.deleteCart(productIdx);
		return "redirect:/cart.do";
	}
	
	@ResponseBody
	@RequestMapping(value="/cart/cartItemDelete.do")
	public Map<String, String> cartItemDelete(@RequestParam("productIdx") int productIdx) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		
		jService.deleteCart(productIdx);
		
		result.put("result", "success");
		
		return result;
	}

	@RequestMapping("/cart/order/success.do")
	public String ordersuccess(JDto success) throws Exception {
		jService.updateSuccess(success);
		return "redirect:/history.do";
	}

	@RequestMapping("/history.do")
	public ModelAndView historypage() throws Exception {
		ModelAndView mv = new ModelAndView("/cart/history");
		List<JDto> successList = jService.selectSuccessList();
		mv.addObject("successList", successList);
		return mv;
	}

}
