package com.bitc.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProjectDto {
	
	
	private int productIdx;
	private int productCategoryIdx;
	private String ProductName;
	private String ProductPrice;
	private String productCategoryName;
	
	private int fileIdx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private String fileSize;
	
//	첨부파일에 대한 정보를 저장하기 위한 멤버 변수를 추가함
	private List<ProjectDto> fileList;


	

}
