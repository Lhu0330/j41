package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.dto.AdminNoticeDto;
import com.bitc.dto.AdminNoticeFileDto;
import com.github.pagehelper.Page;

// mybatis와 연결되어 있다는 것을 의미하는 어노테이션
@Mapper
public interface AdminNoticeMapper {

//	데이터 베이스 연결하여 게시글 목록을 불러오는 메서드
	Page<AdminNoticeDto> selectAdminNotice() throws Exception;
	
//	DB와 연결하여 게시글을 등록하는 메서드
	void insertAdminNotice(AdminNoticeDto adnot) throws Exception;
	
//	DB와 연결하여 지정한 게시글의 모든 정보를 가져오는 메서드
	AdminNoticeDto selectAdminNoticeDetail(int noticeIdx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 삭제하는 메서드
	void deleteAdminNotice(int idx) throws Exception;
	
//	DB와 연결하여 지정한 게시글을 DB에서 수정하는 메서드
	void updateAdminNotice(AdminNoticeDto adnot) throws Exception;
	
	List<AdminNoticeFileDto> selectAdminNoticeFileList(int idx) throws Exception;
	
	AdminNoticeFileDto selectAdminNoticeFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;
	
	void insertAdminNoticeFileList(List<AdminNoticeFileDto> list) throws Exception;
}
