package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.JDto;
import com.bitc.mapper.JMapper;

@Service
public class JServiceImpl implements JService {

	@Autowired
	private JMapper jMapper;

	@Override
	public List<JDto> selectCartList() throws Exception {
		return jMapper.selectCartList();
	}
	
	@Override
	public List<JDto> selectPayList() throws Exception {
		return jMapper.selectPayList();
	}
	
	@Override
	public List<JDto> selectSuccessList() throws Exception {
		return jMapper.selectSuccessList();
	}
	
	@Override
	public JDto selectCostCalculate(JDto cart) throws Exception {
		return jMapper.selectCostCalculate(cart);
	}

	@Override
	public void insertCart(JDto cart) throws Exception {
		jMapper.insertCart(cart);
	}

	@Override
	public void deleteCart(int productIdx) throws Exception {
		jMapper.deleteCart(productIdx);
	}
	
	@Override
	public void checkedCart(int[] productIdx) throws Exception {
		for (int i = 0; i < productIdx.length; i++) {
			jMapper.checkedCart(productIdx[i]);
		}
	}

	
	@Override
	public void checkedNotCart() throws Exception {
		jMapper.checkedNotCart();
	}

	@Override
	public void increaseCart(int productIdx) throws Exception {
		jMapper.increaseCart(productIdx);
	}
	
	@Override
	public void decreaseCart(int productIdx) throws Exception {
		jMapper.decreaseCart(productIdx);
	}
	
	@Override
	public void updateSuccess(JDto success) throws Exception {
		jMapper.updateSuccess(success);
	}
	
	@Override
	public void addCart(int productIdx, int cartQty) throws Exception {
		jMapper.addCart(productIdx, cartQty);
	}

}
