package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.JDto;

@Mapper
public interface JMapper {

	public List<JDto> selectCartList() throws Exception;
	
	public List<JDto> selectPayList() throws Exception;
	
	public List<JDto> selectSuccessList() throws Exception;
	
	public JDto selectCostCalculate(JDto cart) throws Exception;

	public void insertCart(JDto cart) throws Exception;

	public void deleteCart(int productIdx) throws Exception;

	void checkedCart(int productIdx) throws Exception;
	
	void checkedNotCart() throws Exception;
	
	void increaseCart(int productIdx) throws Exception;
	
	void decreaseCart(int productIdx) throws Exception;
	
	void updateSuccess(JDto success) throws Exception;
	
	public void addCart(int productIdx, int cartQty) throws Exception;

}
