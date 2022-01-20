package com.bitc.mapper;


import org.apache.ibatis.annotations.Mapper;


import com.bitc.dto.AdminMemberDto;
import com.github.pagehelper.Page;

// mybatis와 연결되어 있다는 것을 의미하는 어노테이션
@Mapper
public interface AdminMemberMapper {

//	데이터 베이스 연결하여 게시글 목록을 불러오는 메서드
	Page<AdminMemberDto> selectAdminMember() throws Exception;
		
//	DB와 연결하여 지정한 게시글의 모든 정보를 가져오는 메서드
	AdminMemberDto selectAdminMemberDetail(int MemberIdx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 삭제하는 메서드
	void deleteAdminMember(int idx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 수정하는 메서드
	void updateAdminMember(AdminMemberDto adnot) throws Exception;
	
}
