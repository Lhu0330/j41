package com.bitc.dto;

import lombok.Data;

@Data
public class JDto {

	private int productIdx;
	private String productName;
	private int productPrice;
	private int deliveryCost;
	private int cartQty;
	private int successQty;
	private int productStockCnt;
	private char checkedYn;
	private int bsCost;
	private int dsCost;
	private int finalCost;
	private int customerIdx;
	private int adminStore;
	

}
