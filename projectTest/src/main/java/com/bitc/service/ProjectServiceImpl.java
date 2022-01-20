package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.common.FileUtils;
import com.bitc.dto.ProductFileDto;
import com.bitc.dto.ProjectDto;
import com.bitc.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private FileUtils fileUtils;

	@Override
	public List<ProjectDto> selectJrList() throws Exception {
		
		return projectMapper.selectJrList();
		
	}

	@Override
	public List<ProjectDto> selectList() throws Exception {
		return projectMapper.selectList();
	}
	

	@Override
	public ProjectDto selectBoardDetail(int productIdx) throws Exception {
		
		ProjectDto board = projectMapper.selectBoardDetail(productIdx);
		List<ProductFileDto> fileList = projectMapper.selectBoardFileList(productIdx);
		board.setFileList(fileList);
		return board;
	}
	
		@Override
		public ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
			return projectMapper.selectBoardFileInfo(fileIdx, boardIdx);
		}



		}
		
	
