package com.callor.file.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.dao.BBsDao;
import com.callor.file.model.BBsDto;
import com.callor.file.model.FileDto;
import com.callor.file.service.BBsService;
import com.callor.file.service.FileService;
import com.callor.file.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BBsServiceImplV1 implements BBsService{

	protected final GalleryService galleryService;
	protected final FileService fileService;
	protected final BBsDao bbsDao;
	public BBsServiceImplV1(GalleryService galleryService, FileService fileService, BBsDao bbsDao) {
		this.galleryService = galleryService;
		this.fileService = fileService;
		this.bbsDao = bbsDao;
	}

	@Override
	public List<BBsDto> selectAll() {
			return bbsDao.selectAll();
	}
	
	/*
	 * @Bean : Component 설정 Annotation
	 * @Bean : 객체를 생성하여 컨테이너에 보관해 달라 라는 요청
	 * 원래 @Bean 의 역할과 달리 TABLE 을 생성하기 위한 코드로 변형
	 */
	@Autowired
	public void create_table() {
		try {
			bbsDao.create_bbs_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void insert(BBsDto bbsDto, MultipartFile b_file, MultipartHttpServletRequest b_files) {
		
		try {
			String fileName = fileService.fileUp(b_file);
			if(fileName != null && !fileName.isBlank()) {
				bbsDto.setB_image(fileName);
				bbsDto.setB_origin_image(b_file.getOriginalFilename());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bbsDao.insert(bbsDto);
		log.debug("게시판 ID {}", bbsDto.getB_seq());
		if(b_files.getFiles("b_files").size()< 1) {
			return;
		}
		
		
		// form에 multiple 로 설정된 input tag 이 이름(b_files)
		try {
			List<FileDto> files = fileService.filesUp(b_files);
			galleryService.insert(files, bbsDto.getB_seq());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Transactional
	@Override
	public BBsDto findById(long b_seq) {
		
		BBsDto bbsDto = bbsDao.findById(b_seq);
		List<FileDto> fileList = galleryService.findListByBSeq(b_seq);
		bbsDto.setM_files(fileList);
		return bbsDao.findById(b_seq);
	}

	/*
	 * 파일포함한 Update 
	 * 1. 새롭게 업로드된 대표 파일과 원래 Table 에 저장된 파일이름 비교
	 * 2. 업로드된 파일과 Table 에 저장된 파일이 서로 다르면
	 * 		업로드된 파일 삭제
	 * 3. 새로운 파일 업로드
	 * 4. 업로드된 새로운 파일정보 Table 저장
	 */
	@Override
	public int update(BBsDto bbsDto, MultipartFile b_file, MultipartHttpServletRequest b_files) {
		String upload_name = b_file.getOriginalFilename();
		long b_seq = bbsDto.getB_seq();
		
		BBsDto resultDto = bbsDao.findById(b_seq);
		String old_name = resultDto.getB_origin_image();
		
		// 새로업로드 된 이미지가 있고,
		// 원래 저장된 파일 이름과 다르면 
		if( !upload_name.isBlank() && !upload_name.equals(old_name)) {
			// 원래 저장된(업로드된)파일을 삭제하고 
			fileService.delete(resultDto.getB_image());
			try {
				// 새로운 파일을 업로드한다. 
				upload_name = fileService.fileUp(b_file);
				// 새로운 파일정보(fileName, 업로드 이름)을 Dto 에 setting
				bbsDto.setB_image(upload_name);
				bbsDto.setB_origin_image(b_file.getOriginalFilename());
				// Update 실행 
				bbsDao.update(bbsDto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 만약 파일이 새롭게 선택된 것이 없으면 
			// 원래 DB 에 저장된 이름을 다시 bbsDto 에 setting 하고 update 하기 
		} else {
			bbsDto.setB_image(resultDto.getB_image());
			bbsDto.setB_origin_image(resultDto.getB_origin_image());
			bbsDao.update(bbsDto);
		}
		
		List<MultipartFile> files = b_files.getFiles("b_files");
	
		try {
			if(files.size() > 0 ) {
				List<FileDto> filesList;
				filesList = fileService.filesUp(b_files);
				galleryService.insert(filesList, b_seq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}





