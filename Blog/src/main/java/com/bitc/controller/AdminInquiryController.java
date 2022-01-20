package com.bitc.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.AdminInquiryDto;
import com.bitc.dto.AdminInquiryFileDto;
import com.bitc.service.AdminInquiryService;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminInquiryController {

	@Autowired
	private AdminInquiryService adminInquiryService;
	
	@RequestMapping(value="/j41/adminInquiry" , method=RequestMethod.GET)
	public ModelAndView openAdminInquiry(@RequestParam(required = false, defaultValue= "1") int p) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminInquiry");
		mv.addObject("AdminInquiryList", new PageInfo<>(adminInquiryService.selectAdminInquiry(p),10)); 
		return mv;
	}
	
//	이부분은 등록부분인데 문의사항은 답변하기만 있으면 되어서 비활성화 시킴
	@RequestMapping(value="/j41/adminInsertInquiry", method=RequestMethod.GET)
	public String writeAdminInquiry() throws Exception {
		return "/admin/AdminRegistrationInquiry";
	}
	
	@RequestMapping(value="/j41/InquiryInserting", method=RequestMethod.POST)
	public String insertAdminInquiry(AdminInquiryDto adnot, MultipartHttpServletRequest multiFile) throws Exception {
		adminInquiryService.insertAdminInquiry(adnot, multiFile);
		
		return "redirect:/j41/adminInquiry";
	}
	
	@RequestMapping(value="/j41/adminInquiryDetail/{inquiryIdx}", method=RequestMethod.GET)
	public ModelAndView selectAdminInquiryDetail(@PathVariable("inquiryIdx") int inquiryIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminInquiryResponse");
			
		AdminInquiryDto AdminInquiry = adminInquiryService.selectAdminInquiryDetail(inquiryIdx);
		mv.addObject("AdminInquiryList", AdminInquiry);
		
		return mv;
	}
	
	@RequestMapping(value="/j41/adminInquiryUpdate/{inquiryIdx}", method=RequestMethod.POST)
	public String updateAdminInquiry(AdminInquiryDto adnot) throws Exception {
		adminInquiryService.updateAdminInquiry(adnot);
		return "redirect:/j41/adminInquiry";
	}
//	문의 삭제는 문의올린측에서 하는걸로
	@RequestMapping(value="/j41/adminInquiryDelete/{inquiryIdx}", method=RequestMethod.POST)
	public String deleteBlog(@PathVariable("inquiryIdx") int inquiryIdx) throws Exception {
		adminInquiryService.deleteAdminInquiry(inquiryIdx);
		return "redirect:/j41/adminInquiry";
	}
	
//	파일 다운로드 부분

	@RequestMapping("/board/downloadInquiryFile.do")
	public void downloadBoardFile(@RequestParam("fileIdx") int fileIdx, @RequestParam("boardIdx") int boardIdx, HttpServletResponse response) throws Exception {

		AdminInquiryFileDto boardFile = adminInquiryService.selectAdminInquiryFileInfo(fileIdx, boardIdx);
		
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













