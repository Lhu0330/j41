package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.common.InquiryFileUtils;

import com.bitc.dto.AdminInquiryDto;
import com.bitc.dto.AdminInquiryFileDto;
import com.bitc.mapper.AdminInquiryMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

// 내부에서 자바 로직을 처리하는 어노테이션
// 지정한 interface 대신 실행하는 의미

@Service
public class AdminInquiryServiceImpl implements AdminInquiryService {

	@Autowired
	private AdminInquiryMapper adminInquiryMapper;
	
//	@Autowired
	private InquiryFileUtils fileUtils;
	
//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public Page<AdminInquiryDto> selectAdminInquiry(int p) throws Exception {
//		mybatis와 연결되어 있는 AddressMapper를 이용하여 실제 데이터베이스에서 데이터를 조회
		PageHelper.startPage(p,10);
		Page<AdminInquiryDto> aaa = adminInquiryMapper.selectAdminInquiry();
		return aaa;
//		return adminInquiryMapper.selectAdminInquiry();
	}

//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public void insertAdminInquiry(AdminInquiryDto adnot, MultipartHttpServletRequest multiFiles) throws Exception {
//		DB를 조작하는 Mapper의 insertAddress()메서드를 사용하여 실제 DB에 데이터를 추가함
		adminInquiryMapper.insertAdminInquiry(adnot);
		
		List<AdminInquiryFileDto> list = fileUtils.parseFileInfo(adnot.getInquiryIdx(), multiFiles);
		
//		분석된 파일 리스트의 내용이 있는지 확인하고 Mapper를 통해서 DB에 저장
		if (CollectionUtils.isEmpty(list) == false) {
			adminInquiryMapper.insertAdminInquiryFileList(list);
		}
	}	
	
	@Override
	public void deleteAdminInquiry(int InquiryIdx) throws Exception {
	adminInquiryMapper.deleteAdminInquiry(InquiryIdx);
	}

	@Override
	public AdminInquiryDto selectAdminInquiryDetail(int noticeIdx) throws Exception {
		AdminInquiryDto adnot = adminInquiryMapper.selectAdminInquiryDetail(noticeIdx);
		
		List<AdminInquiryFileDto> adnotFi = adminInquiryMapper.selectAdminInquiryFileList(noticeIdx);
		adnot.setFileList(adnotFi);
		return adnot;
	}
	
	@Override
	public void updateAdminInquiry(AdminInquiryDto adnot) throws Exception {
		adminInquiryMapper.updateAdminInquiry(adnot);
	}
	
	@Override
	public AdminInquiryFileDto selectAdminInquiryFileInfo(int fileIdx, int boardIdx) throws Exception {
		return adminInquiryMapper.selectAdminInquiryFileInfo(fileIdx, boardIdx);
	}
}








