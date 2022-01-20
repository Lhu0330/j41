package com.bitc.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.AdminProductDto;
import com.bitc.dto.AdminProductFileDto;
import com.bitc.dto.CategoryProductDto;
import com.bitc.service.AdminProductService;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService adminProductService;
	
	@RequestMapping(value="/j41/adminProduct" , method=RequestMethod.GET)
	public ModelAndView openAdminproduct(@RequestParam(required = false, defaultValue= "1") int p) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminStock");
		mv.addObject("AdminStockList", new PageInfo<>(adminProductService.selectAdminProduct(p),10)); 
		return mv;
	}
	
	@RequestMapping(value="/j41/adminInsertProduct", method=RequestMethod.GET)
	public ModelAndView writeAdminproduct() throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminRegistrationProduct");
		List<CategoryProductDto> CategoryList = adminProductService.selectCategoryList();
		mv.addObject("AdminCategoryList", CategoryList ); 
		return mv;
	}
	
	@RequestMapping(value="/j41/ProductInserting", method=RequestMethod.POST)
	public String insertAdminProduct(AdminProductDto adnot, MultipartHttpServletRequest multiFile) throws Exception {
		adminProductService.insertAdminProduct(adnot, multiFile);
		
		return "redirect:/j41/adminProduct";
	}
	
	@RequestMapping(value="/j41/adminProductDetail/{productIdx}", method=RequestMethod.GET)
	public ModelAndView selectAdminProductDetail(@PathVariable("productIdx") int productIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminproductDetail");
			
		AdminProductDto AdminProduct = adminProductService.selectAdminProductDetail(productIdx);
		mv.addObject("AdminProductList", AdminProduct);
		
		return mv;
	}
	
	@RequestMapping(value="/j41/adminProductCategory/list", method=RequestMethod.GET)
	@ResponseBody
	public List<CategoryProductDto> CategoryProduct() throws Exception {
		List<CategoryProductDto> CategoryList = adminProductService.selectCategoryList();
		return CategoryList;
	}
	
	@RequestMapping(value="/j41/adminProductUpdate/{productIdx}", method=RequestMethod.POST)
	public String updateAdminproduct(AdminProductDto adnot) throws Exception {
		adminProductService.updateAdminProduct(adnot);
		return "redirect:/j41/adminProduct";
	}
	
	@RequestMapping(value="/j41/adminProductDelete/{productIdx}", method=RequestMethod.POST)
	public String deleteBlog(@PathVariable("productIdx") int productIdx) throws Exception {
		adminProductService.deleteAdminProduct(productIdx);
		return "redirect:/j41/adminProduct";
	}
	
//	파일 다운로드 부분

	@RequestMapping("/board/downloadProductFile.do")
	public void downloadBoardFile(@RequestParam("fileIdx") int fileIdx, @RequestParam("boardIdx") int boardIdx, HttpServletResponse response) throws Exception {

		AdminProductFileDto boardFile = adminProductService.selectAdminProductFileInfo(fileIdx, boardIdx);
		
		if (ObjectUtils.isEmpty(boardFile) == false) {
			String fileName = boardFile.getOriginalFileName();
			

			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));
			

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);

			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			

			response.getOutputStream().write(files);

			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
}













