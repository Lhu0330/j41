package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.dto.ProductFileDto;
import com.bitc.dto.ProjectDto;

@Mapper
public interface ProjectMapper {

	public List<ProjectDto> selectJrList() throws Exception;

	public List<ProjectDto> selectList() throws Exception;

	public ProjectDto selectBoardDetail(int idx) throws Exception;
	
//	DB에 연결하여 게시글의 첨부파일 정보를 DB에 저장하는 메서드
	void insertBoardFileList(List<ProductFileDto> list) throws Exception;
	
//	DB에 연결하여 게시글의 첨부파일 정보를 가져오는 메서드
	List<ProductFileDto> selectBoardFileList(int idx) throws Exception;	
	
	
	ProductFileDto selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;


	
	
	
}

