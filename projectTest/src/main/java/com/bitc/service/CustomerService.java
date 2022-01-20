package com.bitc.service;

import java.util.List;

import com.bitc.dto.CustomerDto;
import com.bitc.dto.OrdersDto;

public interface CustomerService {

	// ID 중복 확인
	public CustomerDto idCheck(String customerId) throws Exception;
	
	// 닉네임 중복 확인
	public CustomerDto nickNameCheck(String customerNickName) throws Exception;
		
	// 회원 추가
	public void insertCustomer(CustomerDto customer) throws Exception;

	// 로그인 정보 확인
	public int selectCustomerInfoYn(String customerId, String customerPw) throws Exception;

	// 회원 정보 수정 페이지
	public CustomerDto selectCustomerDetail(String customerId) throws Exception;	
	
	// 회원 정보 수정
	public void editCustomerDetail(CustomerDto customer) throws Exception;

	// 회원 탈퇴
	public void deleteAccount(String customerId) throws Exception;

	// 주문 내역 보기
	public List<OrdersDto> selectOrderList(int customerIdx) throws Exception;

}
