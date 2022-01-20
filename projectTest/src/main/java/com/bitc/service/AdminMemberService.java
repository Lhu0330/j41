package com.bitc.service;



import com.bitc.dto.AdminMemberDto;

import com.github.pagehelper.Page;

// Controller에서 사용할 비지니스 로직의 사용방법을 제공
public interface AdminMemberService {

//	게시판의 게시글 목록을 불러오는 추상 메서드
	Page<AdminMemberDto> selectAdminMember(int p) throws Exception;
	
	
//	지정한 게시글을 DB에서 삭제하는 추상 메서드
	void deleteAdminMember(int MemberIdx) throws Exception;
	
//	지정한 게시글을 DB에서 수정하는 추상 메서드
	void updateAdminMember(AdminMemberDto anot) throws Exception;
	
//	지정한 게시글의 모든 정보를 DB에서 가져오는 추상 메서드
	AdminMemberDto selectAdminMemberDetail(int MemberIdx) throws Exception;
	
}
