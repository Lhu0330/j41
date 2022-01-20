package com.bitc.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProjectDto {
	
	private int productIdx;
	private int productCategoryIdx;
	private String ProductName;
	private String ProductPrice;
	private List<ProductFileDto> fileList;
	
	

}
