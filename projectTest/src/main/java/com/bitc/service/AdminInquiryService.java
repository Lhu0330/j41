package com.bitc.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.dto.AdminInquiryDto;
import com.bitc.dto.AdminInquiryFileDto;
import com.github.pagehelper.Page;

// Controller에서 사용할 비지니스 로직의 사용방법을 제공
public interface AdminInquiryService {

//	게시판의 게시글 목록을 불러오는 추상 메서드
	Page<AdminInquiryDto> selectAdminInquiry(int p) throws Exception;
	
//	DB에 게시글 추가하는 추상 메서드
	void insertAdminInquiry(AdminInquiryDto anot,MultipartHttpServletRequest multiFile) throws Exception;
	
//	지정한 게시글을 DB에서 삭제하는 추상 메서드
	void deleteAdminInquiry(int inquiryIdx) throws Exception;
	
//	지정한 게시글을 DB에서 수정하는 추상 메서드
	void updateAdminInquiry(AdminInquiryDto anot) throws Exception;
	
//	지정한 게시글의 모든 정보를 DB에서 가져오는 추상 메서드
	AdminInquiryDto selectAdminInquiryDetail(int inquiryIdx) throws Exception;
	
	AdminInquiryFileDto selectAdminInquiryFileInfo(int fileIdx, int boardIdx) throws Exception;
}
