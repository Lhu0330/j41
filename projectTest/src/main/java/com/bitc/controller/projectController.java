package com.bitc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.ProjectDto;
import com.bitc.service.ProjectService;
import com.github.pagehelper.PageInfo;

@Controller
public class projectController {

	@Autowired
	public ProjectService projectService;
	
	//메인화면
		@RequestMapping(value="/jr41", method=RequestMethod.GET)
		public ModelAndView openJr() throws Exception {
			ModelAndView mv = new ModelAndView("/main");
			
			List<ProjectDto> jrList = projectService.selectJrList();
			mv.addObject("jrList",jrList);
			
			return mv;
			
		}
		  // 질문 : 디버그하니 productCategoryIdx 값이 안나옴
		
//		 @RequestMapping(value="/jr41/list", method=RequestMethod.GET)
//		   public ModelAndView openList() throws Exception {
//		      ModelAndView mv = new ModelAndView("/productList");
//		      
//		      List<ProjectDto> boardList = projectService.selectList();
//		      mv.addObject("boardList", boardList);
//		      
//		      return mv;
//		   }
//		 
		
		
		
		 
			/*
			 * // 카테고리별 상품 리스트
			 * 
			 * @RequestMapping(value="/jr41/list/{productCategoryIdx}",
			 * method=RequestMethod.GET) public ModelAndView
			 * openMenu(@PathVariable("productCategoryIdx") int productCategoryIdx) throws
			 * Exception { ModelAndView mv = new ModelAndView("/productList");
			 * 
			 * List<ProjectDto> MenuList =
			 * projectService.selectMenuList(productCategoryIdx);
			 * mv.addObject("MenuList",MenuList); return mv; }
			 */
		 
		 @RequestMapping(value="/jr41/list/{productCategoryIdx}", method=RequestMethod.GET)
		  public ModelAndView openMenu(@RequestParam(required = false, defaultValue= "1", value="pageNum") int pageNum, @PathVariable("productCategoryIdx") int productCategoryIdx) throws Exception {
			ModelAndView mv = new ModelAndView("/productList");
		  
			PageInfo<ProjectDto> MenuList = new PageInfo<>(projectService.selectMenuList(pageNum,productCategoryIdx),5);
		  mv.addObject("MenuList",MenuList);
		  
		  if (MenuList.getList().size() > 0) {
			  mv.addObject("productCategoryIdx", MenuList.getList().get(0).getProductCategoryIdx());  
		  }
		  
		  return mv;
		}
		
		 //제품 상세 화면
		@RequestMapping(value="/jr41/list/detail/{ProductIdx}", method=RequestMethod.GET)
		public ModelAndView openBoardDetail(@PathVariable("ProductIdx") int ProductIdx) throws Exception {
			ModelAndView mv = new ModelAndView("/detail");
			
			ProjectDto board = projectService.selectBoardDetail(ProductIdx);
			mv.addObject("board", board);
			
			return mv;
		}
		
}
