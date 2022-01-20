package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.CustomerDto;
import com.bitc.dto.OrdersDto;
import com.bitc.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	// ID 중복 확인
	@Override
	public CustomerDto idCheck(String customerId) throws Exception {
		CustomerDto customer = customerMapper.idCheck(customerId);
		return customer;
	}

	// 닉네임 중복 확인
	@Override
	public CustomerDto nickNameCheck(String customerNickName) throws Exception {
		CustomerDto customer = customerMapper.nickNameCheck(customerNickName);
		return customer;
	}
	
	// 회원 추가
	@Override
	public void insertCustomer(CustomerDto customer) throws Exception {
		customerMapper.insertCustomer(customer);
	}
	
	// 로그인 정보 확인
	@Override
	public int selectCustomerInfoYn(String customerId, String customerPw) throws Exception {
		return customerMapper.selectCustomerInfoYn(customerId, customerPw);
	}

	// 회원 정보 수정 페이지
	@Override
	public CustomerDto selectCustomerDetail(String customerId) throws Exception {
		return customerMapper.selectCustomerDetail(customerId);
	}
	
	// 회원 정보 수정
	@Override
	public void editCustomerDetail(CustomerDto customer) throws Exception {
		customerMapper.editCustomerDetail(customer);
	}

	// 회원 탈퇴
	@Override
	public void deleteAccount(String customerId) throws Exception {
		customerMapper.deleteAccount(customerId);
	}

	// 주문 내역 보기
	@Override
	public List<OrdersDto> selectOrderList(int customerIdx) throws Exception {
		return customerMapper.selectOrderList(customerIdx);
	}
}
