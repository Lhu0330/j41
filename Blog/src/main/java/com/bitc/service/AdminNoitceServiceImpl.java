package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.common.NoticeFileUtils;
import com.bitc.dto.AdminNoticeDto;
import com.bitc.dto.AdminNoticeFileDto;
import com.bitc.mapper.AdminNoticeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

// 내부에서 자바 로직을 처리하는 어노테이션
// 지정한 interface 대신 실행하는 의미

@Service
public class AdminNoitceServiceImpl implements AdminNoticeService {

	@Autowired
	private AdminNoticeMapper adminNoticeMapper;
	
	@Autowired
	private NoticeFileUtils fileUtils;
	
//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public Page<AdminNoticeDto> selectAdminNotice(int p) throws Exception {
//		mybatis와 연결되어 있는 AddressMapper를 이용하여 실제 데이터베이스에서 데이터를 조회
		PageHelper.startPage(p,10);
		return adminNoticeMapper.selectAdminNotice();
	}

//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public void insertAdminNotice(AdminNoticeDto adnot, MultipartHttpServletRequest multiFiles) throws Exception {
//		DB를 조작하는 Mapper의 insertAddress()메서드를 사용하여 실제 DB에 데이터를 추가함
		adminNoticeMapper.insertAdminNotice(adnot);
		
		List<AdminNoticeFileDto> list = fileUtils.parseFileInfo(adnot.getNoticeIdx(), multiFiles);
		
//		분석된 파일 리스트의 내용이 있는지 확인하고 Mapper를 통해서 DB에 저장
		if (CollectionUtils.isEmpty(list) == false) {
			adminNoticeMapper.insertAdminNoticeFileList(list);
		}
	}	
	
	@Override
	public void deleteAdminNotice(int noticeIdx) throws Exception {
		adminNoticeMapper.deleteAdminNotice(noticeIdx);
	}

	@Override
	public AdminNoticeDto selectAdminNoticeDetail(int noticeIdx) throws Exception {
		AdminNoticeDto adnot = adminNoticeMapper.selectAdminNoticeDetail(noticeIdx);
		
		List<AdminNoticeFileDto> adnotFi = adminNoticeMapper.selectAdminNoticeFileList(noticeIdx);
		adnot.setFileList(adnotFi);
		return adnot;
	}
	
	@Override
	public void updateAdminNotice(AdminNoticeDto adnot) throws Exception {
		adminNoticeMapper.updateAdminNotice(adnot);
	}
	
	@Override
	public AdminNoticeFileDto selectAdminNoticeFileInfo(int fileIdx, int boardIdx) throws Exception {
		return adminNoticeMapper.selectAdminNoticeFileInfo(fileIdx, boardIdx);
	}
}








