package com.bitc.dto;

import lombok.Data;

// 롬복이란?
// 데이터 베이스와 매핑되는 dto 객체를 생성 시 getter/setter를 자동으로 생성해줌

// getter/setter/toString 메서드를 자동으로 생성해 줌
@Data
public class AdminNoticeFileDto {

	private int noticeBoardFileIdx;
	private int noticeIdx;
	private String nbfOriginalFileName;
	private String nbfStoredFilePath;
//	원래는 long 타입으로 사용해야 하지만 sql에서 사용자가 알아보기 쉽도록 kb부터 확인하는 형태로 변경하는 수식이 들어가면서 fileSize가 String 타입으로 변환되어 DTO에서도 String 타입으로 데이터를 사용함
	private String nbfFileSize;
	private String customersNickName;
	private String deletedYn;
}
