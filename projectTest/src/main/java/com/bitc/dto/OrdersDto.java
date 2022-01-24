package com.bitc.dto;

import lombok.Data;

@Data
public class OrdersDto {

	private int orderIdx;
	private int customerIdx;
	private String orderDate;
	private String dispatchedYn;
}
