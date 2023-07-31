package com.callor.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.model.FileDto;

public interface FileService {

	public String fileup(MultipartFile file) throws Exception;
	public List<FileDto> filesUP(MultipartHttpServletRequest files) throws Exception;
	
	public String delete(String fileName);
	
	
	}
