package com.bitc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.ProjectDto;
import com.bitc.service.ProjectService;

@Controller
public class projectController {

	@Autowired
	public ProjectService projectService;
	
	
	@RequestMapping(value="/jr41", method=RequestMethod.GET)
	public ModelAndView openJr() throws Exception {
		ModelAndView mv = new ModelAndView("/main");
		
		List<ProjectDto> jrList = projectService.selectJrList();
		mv.addObject("jrList",jrList);
		
		return mv;
		
	}
	
	 @RequestMapping(value="/jr41/list", method=RequestMethod.GET)
	   public ModelAndView openList() throws Exception {
	      ModelAndView mv = new ModelAndView("/productList");
	      
	      List<ProjectDto> boardList = projectService.selectList();
	      mv.addObject("boardList", boardList);
	      
	      return mv;
	   }
	 
	 
//////////////////////////////////////////////////////////////////////////////////////

		
//		@ResponseBody : 해당 어노테이션을 사용 시 View를 반환하지 않고 데이터 자체를 반환 
		  // 원래는 html 템플릿반환하는데 이거는 뷰에 실려서 데이터가 온느게 아니라 데이터만 옴 
		
//		value : RequestMapping 어노테이션에 여러개의 옵션을 사용할 경우 구분하기 위한 속성명, 클라이언트에서 요청하기 위한 URL을 입력하는 속성, 
		//       RequestMapping에 단 하나의 속성만 사용 시 value가 기본이며, 삭제 가능함
//		method : RequestMapping 어노테이션의 옵션 중 하나로 클라이언트와 통신 시 사용하는 데이터 전송 방식을 구분하기 위한 것, 미입력 시 자동 판단
		@ResponseBody
		@RequestMapping(value="/ajax/calResult.do", method=RequestMethod.POST)
		public Object ajaxCalResult(ProjectDto cal) throws Exception {
//			HashMap은 키와 값이 1:1로 매칭되어 있는 데이터 타입
//			하나의 변수명으로 여러개의 데이터를 저장할 수 있는 데이터 타입
//			Javascript의 object 타입과 비슷함, json(자바스크립트의 오븐젝트 파일) 데이터로 변환이 쉬움
			//                                    ㄴ> var aaa= {num1: 111, num2 : 222} 
			  
			HashMap<String, Object> map = new HashMap<String, Object>();
			       // 키,    값 
			map.put("price", cal.getProductName());
			map.put("name", cal.getProductPrice());
			
			return map;
		}
	 
	 
	 
	 
	 
///////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	 
	 //	@RequestMapping(value="/jr41/{productCategoryIdx}", method=RequestMethod.GET)
//	public ModelAndView openJr(@PathVariable("productCategoryIdx") int productCategoryIdx) throws Exception {
//		ModelAndView mv = new ModelAndView("/main");
//		
//		List<ProjectDto> jrList = projectService.selectJrList(productCategoryIdx);
//		mv.addObject("jrList",jrList);
//		return mv;
//		
//	}
//	
	/*
	 * // 카테고리별 상품 리스트
	 * 
	 * @RequestMapping(value = "/list", method = RequestMethod.GET) public void
	 * getList( @RequestParam("i") int productCategoryIdx, Model model) throws
	 * Exception { logger.info("get llist");
	 * 
	 * List<GoodsViewVO> list = null; list = service.list(cateCode);
	 * 
	 * model.addAttribute("list", list);
	 */
//	//메뉴 
//	 @RequestMapping(value="/jr41/{productCategoryIdx}", method=RequestMethod.GET)
//	  public ModelAndView openMenu(@PathVariable("productCategoryIdx") int productCategoryIdx) throws Exception { ModelAndView mv = new
//	  
//	  ModelAndView("/productList");
//	  
//	  List<ProjectDto> MenuList = projectService.selectMenuList(productCategoryIdx);
//	  mv.addObject("MenuList",MenuList); return mv;
//	  
//	  }
	/*
	 * 
	 * @RequestMapping(value="/jr41/{ProductIdx}", method=RequestMethod.GET) public
	 * ModelAndView openBoardDetail(@PathVariable("ProductIdx") int ProductIdx)
	 * throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView("/detail"); ProjectDto restBoard =
	 * projectService.selectBoardDetail(ProductIdx); mv.addObject("restBoard",
	 * restBoard);
	 * 
	 * return mv; }
	 */
	
	@RequestMapping(value="/jr41/detail", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@RequestParam("ProductIdx") int ProductIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/detail");
		
		ProjectDto board = projectService.selectBoardDetail(ProductIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	

}
