package com.bitc.dto;

import lombok.Data;

@Data
public class ProductFileDto {

	private int fileIdx;
	private int productIdx;
	private String originalFileName;
	private String storedFilePath;

	private String fileSize;
}
