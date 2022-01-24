package com.bitc.dto;

import lombok.Data;

@Data
public class OrderDetailDto {

	private int orderDetailIdx;
	private int orderIdx;
	private int productIdx;
	private int orderCnt;
	private int orderSum;
	
	private String productName;
	private int productPrice;
	private int deliveryCost;
}
