package com.callor.file.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.model.FileDto;
import com.callor.file.service.FileService;

@Service
public class FileServiceImplV1 implements FileService{

	protected final String fileUpPath;
	public FileServiceImplV1() {
		this.fileUpPath = "/app/upload";
	}

	@Override
	public String fileup(MultipartFile file) throws Exception {

		if(file.getOriginalFilename().isEmpty()) {
			return null;
		}
		
		// 파일 업로드 할 path 를 File 객체로 생성
		File path = new File(fileUpPath);
		// 만약 업로드할 path 가 없으면
		if(!path.exists()) {
			// 폴더를 생성해라
			path.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		String uuid = UUID.randomUUID().toString();
		
		// 업로드할 파일 이름에 UUID를 부착하여 injection 공격 방지 
		fileName = String.format("%s-%s", uuid, fileName);
		
		File uploadFile = new File(fileUpPath, fileName);

		// file 에 담긴 파일을 uploadFile 로 서버에 전송
		file.transferTo(uploadFile);
		
		// 새로 생성된 이름을 return
		return fileName;
	}

	@Override
	public List<FileDto> filesUP(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String fileName) {
		if(fileName == null || fileName.isBlank()) {
			return null;
		}
		File delFile = new File(fileUpPath, fileName);
		// file이 있는지 확인하기 
		if(delFile.exists()) {
			// 파일 삭제하기 
			if(delFile.delete()) {
				return "OK";
			}
		}
		
		return null;
	}
	
}
