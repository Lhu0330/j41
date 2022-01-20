package com.bitc.dto;

import lombok.Data;

@Data
public class CustomerDto {
	
	private int customerIdx;
	private String customerEmail;
	private String customerId;
	private String customerPw;
	private String customerName;
	private String customerNickName;
	private String customerAddress;
	private String customerPhone;
	private int customerLevel;	
	private String deletedYn;
}
