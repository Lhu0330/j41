package com.bitc.dto;

import java.util.List;

import lombok.Data;

// 롬복이란?
// 데이터 베이스와 매핑되는 dto 객체를 생성 시 getter/setter를 자동으로 생성해줌

// getter/setter/toString 메서드를 자동으로 생성해 줌
@Data
public class AdminProductDto {
	
	private int idx;
	private int productIdx;
	private int productCategoryIdx;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int productStockCnt;
	private String adminStore;
	private String deletedYn;
	private String deliveryCost;
	private List<AdminProductFileDto> fileList;
	private String productCategoryName;
//	product_category_name
}
