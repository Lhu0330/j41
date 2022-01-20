package com.bitc.dto;

import lombok.Data;

@Data
public class OrderDetailDto {

	int orderDetailIdx;
	int orderIdx;
	int productIdx;
	int orderCnt;
	int orderSum;
}
