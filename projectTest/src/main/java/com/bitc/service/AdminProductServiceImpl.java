package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.common.ProductFileUtils;

import com.bitc.dto.AdminProductDto;
import com.bitc.dto.AdminProductFileDto;
import com.bitc.dto.CategoryProductDto;
import com.bitc.mapper.AdminProductMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

// 내부에서 자바 로직을 처리하는 어노테이션
// 지정한 interface 대신 실행하는 의미

@Service
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private AdminProductMapper adminProductMapper;
	
	@Autowired
	private ProductFileUtils fileUtils;
	
//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public Page<AdminProductDto> selectAdminProduct(int p) throws Exception {
//		mybatis와 연결되어 있는 AddressMapper를 이용하여 실제 데이터베이스에서 데이터를 조회
		PageHelper.startPage(p,10);
		Page<AdminProductDto> aaa = adminProductMapper.selectAdminProduct();
		return aaa;
//		return adminProductMapper.selectAdminProduct();
	}

//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public void insertAdminProduct(AdminProductDto adnot, MultipartHttpServletRequest multiFiles) throws Exception {
//		DB를 조작하는 Mapper의 insertAddress()메서드를 사용하여 실제 DB에 데이터를 추가함
		adminProductMapper.insertAdminProduct(adnot);
		
		List<AdminProductFileDto> list = fileUtils.parseFileInfo(adnot.getProductIdx(), multiFiles);
		
//		분석된 파일 리스트의 내용이 있는지 확인하고 Mapper를 통해서 DB에 저장
		if (CollectionUtils.isEmpty(list) == false) {
			adminProductMapper.insertAdminProductFileList(list);
		}
	}	
	
	@Override
	public void deleteAdminProduct(int ProductIdx) throws Exception {
		adminProductMapper.deleteAdminProduct(ProductIdx);
	}

	@Override
	public AdminProductDto selectAdminProductDetail(int noticeIdx) throws Exception {
		AdminProductDto adnot = adminProductMapper.selectAdminProductDetail(noticeIdx);
		
		List<AdminProductFileDto> adnotFi = adminProductMapper.selectAdminProductFileList(noticeIdx);
		adnot.setFileList(adnotFi);
		return adnot;
	}
	
	@Override
	public void updateAdminProduct(AdminProductDto adnot) throws Exception {
		adminProductMapper.updateAdminProduct(adnot);
	}
	
	@Override
	public AdminProductFileDto selectAdminProductFileInfo(int fileIdx, int boardIdx) throws Exception {
		return adminProductMapper.selectAdminProductFileInfo(fileIdx, boardIdx);
	}

	@Override
	public List<CategoryProductDto> selectCategoryList() {
		return adminProductMapper.selectCategoryList();
	}
}








