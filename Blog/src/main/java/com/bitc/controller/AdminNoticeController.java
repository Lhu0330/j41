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
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.AdminNoticeDto;
import com.bitc.dto.AdminNoticeFileDto;
import com.bitc.service.AdminNoticeService;
import com.github.pagehelper.PageInfo;

@Controller
public class AdminNoticeController {

	@Autowired
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping(value="/j41/adminNotice" , method=RequestMethod.GET)
	public ModelAndView openAdminNotice(@RequestParam(required = false, defaultValue= "1") int p) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminNotice");
		mv.addObject("AdminNoticeList", new PageInfo<>(adminNoticeService.selectAdminNotice(p),10)); 
		return mv;
	}
	
	@RequestMapping(value="/j41/adminInsertNotice", method=RequestMethod.GET)
	public String writeAdminNotice() throws Exception {
		return "/admin/AdminNoticeInsert";
	}
	
	@RequestMapping(value="/j41/noticeInserting", method=RequestMethod.POST)
	public String insertAdminNotice(AdminNoticeDto adnot, MultipartHttpServletRequest multiFile) throws Exception {
		adminNoticeService.insertAdminNotice(adnot, multiFile);
		
		return "redirect:/j41/adminNotice";
	}
	
	@RequestMapping(value="/j41/adminNoticeDetail/{noticeIdx}", method=RequestMethod.GET)
	public ModelAndView selectAdminNoticeDetail(@PathVariable("noticeIdx") int noticeIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/admin/AdminNoticeDetail");
			
		AdminNoticeDto AdminNotice = adminNoticeService.selectAdminNoticeDetail(noticeIdx);
		mv.addObject("AdminNoticeList", AdminNotice);
		
		return mv;
	}
	
	@RequestMapping(value="/j41/adminNoticeUpdate/{noticeIdx}", method=RequestMethod.POST)
	public String updateAdminNotice(AdminNoticeDto adnot) throws Exception {
		adminNoticeService.updateAdminNotice(adnot);
		return "redirect:/j41/adminNotice";
	}
	
	@RequestMapping(value="/j41/adminNoticeDelete/{noticeIdx}", method=RequestMethod.DELETE)
	public String deleteBlog(@RequestParam("noticeIdx") int noticeIdx) throws Exception {
		adminNoticeService.deleteAdminNotice(noticeIdx);
		return "redirect:/j41/adminNotice";
	}
	
//	파일 다운로드 부분

	@RequestMapping("/board/downloadBoardFile.do")
	public void downloadBoardFile(@RequestParam("fileIdx") int fileIdx, @RequestParam("boardIdx") int boardIdx, HttpServletResponse response) throws Exception {

		AdminNoticeFileDto boardFile = adminNoticeService.selectAdminNoticeFileInfo(fileIdx, boardIdx);
		
		if (ObjectUtils.isEmpty(boardFile) == false) {
			String fileName = boardFile.getNbfOriginalFileName();
			

			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getNbfStoredFilePath()));
			

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













