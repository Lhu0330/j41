package com.bitc.dto;

import lombok.Data;

@Data
public class QnaFileDto {

	private int fileIdx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
//	원래는 long 타입으로 사용해야 하지만 sql에서 사용자가 알아보기 쉽도록 kb부터 확인하는 형태로 변경하는 수식이 들어가면서 fileSize가 String 타입으로 변환되어 DTO에서도 String 타입으로 데이터를 사용함
	private String fileSize;
}
