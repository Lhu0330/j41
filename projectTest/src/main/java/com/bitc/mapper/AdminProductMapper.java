package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.dto.AdminProductDto;
import com.bitc.dto.AdminProductFileDto;
import com.bitc.dto.CategoryProductDto;
import com.github.pagehelper.Page;

// mybatis와 연결되어 있다는 것을 의미하는 어노테이션
@Mapper
public interface AdminProductMapper {

//	데이터 베이스 연결하여 게시글 목록을 불러오는 메서드
	Page<AdminProductDto> selectAdminProduct() throws Exception;
	
//	DB와 연결하여 게시글을 등록하는 메서드
	void insertAdminProduct(AdminProductDto adnot) throws Exception;
	
//	DB와 연결하여 지정한 게시글의 모든 정보를 가져오는 메서드
	AdminProductDto selectAdminProductDetail(int ProductIdx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 삭제하는 메서드
	void deleteAdminProduct(int idx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 수정하는 메서드
	void updateAdminProduct(AdminProductDto adnot) throws Exception;
	
	List<AdminProductFileDto> selectAdminProductFileList(int idx) throws Exception;
	
	AdminProductFileDto selectAdminProductFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;
	
	void insertAdminProductFileList(List<AdminProductFileDto> list) throws Exception;

	List<CategoryProductDto> selectCategoryList();
}
