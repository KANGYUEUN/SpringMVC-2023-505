package com.callor.bbs.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.bbs.config.QualifierConfig;
import com.callor.bbs.models.FileDto;
import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Service("fileServiceV1")
@Service(QualifierConfig.SERVICE.FILE_V1)
public class FileServiceImplV1 implements FileService {

	// Server 에 있는 폴더, 자원(resource)에 접근하는 것.
	protected final ResourceLoader resoureceLoader;
	protected final String filePath;

	public FileServiceImplV1(ResourceLoader resourece) {
		this.resoureceLoader = resourece;
		this.filePath = "/files";
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		// filePath = /files
		// /webapp/files 폴더에 대한 정보( resoureceLoader)를 가지고 있는 객체가 된다.
		// /webapp 폴더는 단순한 방법으로 정보를 가져올수 없다.
		// 그래서 resourceLoader라는 객체를 사용하여 관련 정보를 가져온다.
		Resource res = resoureceLoader.getResource(filePath);

		// Tomcat / Project 서버의 files 라는 폴더 정보
		// 파일을 업로드 할 폴더이름을 savePath변수에 저장하기.
		String savePath = res.getURI().getPath();

		// 업로드할 파일 이름
		String originalFileName = file.getOriginalFilename();

		// Tomcat / Project 서버의files 폴더와 file이름을 사용하여
		// File 이라는 객체를 생성한다.
		File upLoadFile = new File(savePath, originalFileName);

		log.debug(upLoadFile.getAbsolutePath());

		// MultipartFile 이 upLoadFile 정보를 참조하여
		// 서버로 파일을 전송하라.
		file.transferTo(upLoadFile);
		return originalFileName;
	}

	@Override
	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception {
		List<MultipartFile> fileList = files.getFiles("b_image");
		List<FileDto> returnFiles = new ArrayList<FileDto>();

		for (MultipartFile file : fileList) {
			FileDto fileDto = new FileDto();
			fileDto.setI_originalName(file.getOriginalFilename());
			fileDto.setI_uploadName(this.fileUp(file));
			returnFiles.add(fileDto);
		}

		return returnFiles;
	}

	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
