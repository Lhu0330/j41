package com.bitc.service;

import java.util.List;

import com.bitc.dto.JDto;

public interface JService {
	
	List<JDto> selectCartList() throws Exception;
	
	List<JDto> selectSuccessList() throws Exception;
	
	JDto selectCostCalculate(JDto cart) throws Exception;

	void insertCart(JDto cart) throws Exception;
	
	void deleteCart(int productIdx) throws Exception;
	
	void updateCart(JDto cart) throws Exception;
	
	void updateSuccess(JDto success) throws Exception;
	
}
