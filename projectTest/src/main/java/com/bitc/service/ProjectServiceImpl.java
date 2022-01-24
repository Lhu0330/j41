package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.common.FileUtils;
import com.bitc.dto.ProductFileDto;
import com.bitc.dto.ProjectDto;
import com.bitc.mapper.ProjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private FileUtils fileUtils;
//메인화면
	@Override
	public List<ProjectDto> selectJrList() throws Exception {
		
		return projectMapper.selectJrList();
		
	}

//	@Override
//	public List<ProjectDto> selectList() throws Exception {
//		return projectMapper.selectList();
//	}
	

//	@Override
//	public ProjectDto selectBoardDetail(int productIdx) throws Exception {
//		
//		ProjectDto board = projectMapper.selectBoardDetail(productIdx);
//		List<ProductFileDto> fileList = projectMapper.selectBoardFileList(productIdx);
//		board.setFileList(fileList);
//		return board;
//	}
	
		@Override
		public ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
			return projectMapper.selectBoardFileInfo(fileIdx, boardIdx);
		}

		// 카테고리별 상품화면 
		@Override
		public Page<ProjectDto> selectMenuList(int pageNum, int productCategoryIdx) throws Exception {
			PageHelper.startPage(pageNum, 4);
			return projectMapper.selectMenuList(productCategoryIdx);
		}

		
		
		@Override
		public ProjectDto selectBoardDetail(int productIdx) throws Exception {
	
			ProjectDto board = projectMapper.selectBoardDetail(productIdx);
			List<ProjectDto> fileList = projectMapper.selectBoardFileList(productIdx);
			board.setFileList(fileList);
			return board;
		}



		}
		
	
