package com.bitc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.bitc.dto.AdminMemberDto;
import com.bitc.dto.JDto;
import com.bitc.mapper.AdminMemberMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

// 내부에서 자바 로직을 처리하는 어노테이션
// 지정한 interface 대신 실행하는 의미

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMemberMapper adminMemberMapper;
	

//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의
	@Override
	public Page<AdminMemberDto> selectAdminMember(int p) throws Exception {
//		mybatis와 연결되어 있는 AddressMapper를 이용하여 실제 데이터베이스에서 데이터를 조회
		PageHelper.startPage(p,10);
		Page<AdminMemberDto> aaa = adminMemberMapper.selectAdminMember();
		return aaa;
//		return adminMemberMapper.selectAdminMember();
	}

//	부모인 AddressService 인터페이스가 가지고 있는 추상 메서드를 재정의

	
	@Override
	public void deleteAdminMember(int MemberIdx) throws Exception {
	adminMemberMapper.deleteAdminMember(MemberIdx);
	}

	@Override
	public AdminMemberDto selectAdminMemberDetail(int noticeIdx) throws Exception {
		AdminMemberDto adnot = adminMemberMapper.selectAdminMemberDetail(noticeIdx);
		
		return adnot;
	}
	
	@Override
	public void updateAdminMember(AdminMemberDto adnot) throws Exception {
		adminMemberMapper.updateAdminMember(adnot);
	}
	
	@Override
	public List<JDto> selectMemberList(@Param("customerIdx") int customerIdx, @Param("ads") String ads) throws Exception {
		List<JDto> admh = adminMemberMapper.selectMemberList(customerIdx, ads);
		
		return admh;
	}
	
}








