package com.bitc.service;

import java.util.List;

import com.bitc.dto.ProductFileDto;
import com.bitc.dto.ProjectDto;
import com.github.pagehelper.Page;

public interface ProjectService {

	
	
 //메인화면 	
	List<ProjectDto> selectJrList() throws Exception;
	
//	List<ProjectDto> selectList() throws Exception;
	
 // 메뉴별 화면 
	//List<ProjectDto> selectMenuList(int productCategoryIdx) throws Exception;
	Page<ProjectDto> selectMenuList(int pageNum, int productCategoryIdx) throws Exception;
	
	
// 상세화면
	ProjectDto selectBoardDetail(int productIdx) throws Exception;
	
	
	ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;

	


	
}
