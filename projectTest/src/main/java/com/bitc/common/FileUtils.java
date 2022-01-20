package com.bitc.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.dto.QnaFileDto;

@Component
public class FileUtils {

	public List<QnaFileDto> parseFileInfo(int boardIdx, MultipartHttpServletRequest multiFiles) throws Exception {
		
		if (ObjectUtils.isEmpty(multiFiles)) {
			return null;
		}
		
		List<QnaFileDto> fileList = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String path = "images/" + current.format(format);
		
		File file = new File(path);
		if (file.exists() == false) {
			file.mkdirs(); // 폴더 생성
		}
		
		Iterator<String> iterator = multiFiles.getFileNames();
		String newFileName;
		String originalFileExtension;
		String contentType;
		
		while(iterator.hasNext()) {
			String name = iterator.next();
			List<MultipartFile> list = multiFiles.getFiles(name);
			
			for (MultipartFile mFile : list) {
				if (mFile.isEmpty() == false) {
					contentType = mFile.getContentType();
					if (ObjectUtils.isEmpty(contentType)) {
						break;
					}
					else {
						if (contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						}
						else if (contentType.contains("image/png")) {
							originalFileExtension = ".png";
						}
						else if (contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						}
						else {
							break;
						}
					}

					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
					
					QnaFileDto boardFile = new QnaFileDto();
					boardFile.setBoardIdx(boardIdx);
					
					boardFile.setFileSize(Long.toString(mFile.getSize()));
					boardFile.setOriginalFileName(mFile.getOriginalFilename());
					boardFile.setStoredFilePath(path + "/" + newFileName);
					
					fileList.add(boardFile);
					
					file = new File(path + "/" + newFileName);
					mFile.transferTo(file);
				}
			}
		}
		
		return fileList;
	}
}












