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
	public void checkedCart(int productIdx) throws Exception {
		jMapper.checkedCart(productIdx);
	}

	
	@Override
	public void checkedNotCart(int productIdx) throws Exception {
		jMapper.checkedNotCart(productIdx);
	}

	@Override
	public void updateCart(JDto cart) throws Exception {
		jMapper.updateCart(cart);
	}
	
	@Override
	public void updateSuccess(JDto success) throws Exception {
		jMapper.updateSuccess(success);
	}

}
