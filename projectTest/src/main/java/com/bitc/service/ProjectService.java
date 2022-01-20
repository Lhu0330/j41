package com.bitc.service;

import java.util.List;

import com.bitc.dto.ProductFileDto;
import com.bitc.dto.ProjectDto;

public interface ProjectService {

	
	
	List<ProjectDto> selectJrList() throws Exception;
	
	List<ProjectDto> selectList() throws Exception;


	public ProjectDto selectBoardDetail(int idx) throws Exception;
	
	ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;

	
}
