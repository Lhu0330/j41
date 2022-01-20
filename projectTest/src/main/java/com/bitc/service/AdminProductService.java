package com.bitc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.dto.AdminProductDto;
import com.bitc.dto.AdminProductFileDto;
import com.bitc.dto.CategoryProductDto;
import com.github.pagehelper.Page;

// Controller에서 사용할 비지니스 로직의 사용방법을 제공
public interface AdminProductService {

//	게시판의 게시글 목록을 불러오는 추상 메서드
	Page<AdminProductDto> selectAdminProduct(int p) throws Exception;
	
//	DB에 게시글 추가하는 추상 메서드
	void insertAdminProduct(AdminProductDto anot,MultipartHttpServletRequest multiFile) throws Exception;
	
//	지정한 게시글을 DB에서 삭제하는 추상 메서드
	void deleteAdminProduct(int noticeIdx) throws Exception;
	
//	지정한 게시글을 DB에서 수정하는 추상 메서드
	void updateAdminProduct(AdminProductDto anot) throws Exception;
	
//	지정한 게시글의 모든 정보를 DB에서 가져오는 추상 메서드
	AdminProductDto selectAdminProductDetail(int noticeIdx) throws Exception;
	
	AdminProductFileDto selectAdminProductFileInfo(int fileIdx, int boardIdx) throws Exception;

	List<CategoryProductDto> selectCategoryList();
}
