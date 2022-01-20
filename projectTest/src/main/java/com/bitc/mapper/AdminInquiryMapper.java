package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.dto.AdminInquiryDto;
import com.bitc.dto.AdminInquiryFileDto;
import com.github.pagehelper.Page;

// mybatis와 연결되어 있다는 것을 의미하는 어노테이션
@Mapper
public interface AdminInquiryMapper {

//	데이터 베이스 연결하여 게시글 목록을 불러오는 메서드
	Page<AdminInquiryDto> selectAdminInquiry() throws Exception;
	
//	DB와 연결하여 게시글을 등록하는 메서드
	void insertAdminInquiry(AdminInquiryDto adnot) throws Exception;
	
//	DB와 연결하여 지정한 게시글의 모든 정보를 가져오는 메서드
	AdminInquiryDto selectAdminInquiryDetail(int InquiryIdx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 삭제하는 메서드
	void deleteAdminInquiry(int idx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 수정하는 메서드
	void updateAdminInquiry(AdminInquiryDto adnot) throws Exception;
	
	List<AdminInquiryFileDto> selectAdminInquiryFileList(int idx) throws Exception;
	
	AdminInquiryFileDto selectAdminInquiryFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;
	
	void insertAdminInquiryFileList(List<AdminInquiryFileDto> list) throws Exception;
}
