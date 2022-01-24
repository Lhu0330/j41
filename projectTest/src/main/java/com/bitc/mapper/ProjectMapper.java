package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.ProductFileDto;
import com.bitc.dto.ProjectDto;
import com.github.pagehelper.Page;

@Mapper
public interface ProjectMapper {

	public List<ProjectDto> selectJrList() throws Exception;

	public List<ProjectDto> selectList() throws Exception;

//	DB에 연결하여 게시글의 첨부파일 정보를 DB에 저장하는 메서드
	void insertBoardFileList(List<ProductFileDto> list) throws Exception;
	
//	DB에 연결하여 게시글의 첨부파일 정보를 가져오는 메서드
	List<ProjectDto> selectBoardFileList(int productIdx) throws Exception;	
	
	
	ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;


	// 메뉴별 상품 리스트
	Page<ProjectDto> selectMenuList( int productCategoryIdx) throws Exception;

	// 상품 상세화면
	public ProjectDto selectBoardDetail(int productIdx) throws Exception;
	
	
	
}

