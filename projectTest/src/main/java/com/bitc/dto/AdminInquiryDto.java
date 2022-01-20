package com.bitc.dto;

import java.util.List;

import lombok.Data;

// 롬복이란?
// 데이터 베이스와 매핑되는 dto 객체를 생성 시 getter/setter를 자동으로 생성해줌

// getter/setter/toString 메서드를 자동으로 생성해 줌
@Data
public class AdminInquiryDto {
	
	private int inquiryIdx;
	private String inquiryTitle;
	private String inquiryContents;
	private String inquiryDate;
	private String adminStore;
	private String deletedYn;
	private String responseYn;
	private String inquiryResponseTitle;
	private String inquiryResponseContents;
	private String inquiryResponseDate;
	private String customersNickName;
	private List<AdminInquiryFileDto> fileList;

}
