package com.bitc.dto;

import lombok.Data;

@Data
public class OrdersDto {

	int orderIdx;
	int customerIdx;
	String orderDate;
	String dispatchedYn;
}
