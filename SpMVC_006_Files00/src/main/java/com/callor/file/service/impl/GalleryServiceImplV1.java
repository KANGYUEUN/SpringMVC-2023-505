package com.callor.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.file.dao.FileDao;
import com.callor.file.model.FileDto;
import com.callor.file.service.FileService;
import com.callor.file.service.GalleryService;

@Service
public class GalleryServiceImplV1 implements GalleryService{

	protected final FileService fileService;
	protected final FileDao fileDao;
	public GalleryServiceImplV1(FileService fileService, FileDao fileDao) {
		this.fileService = fileService;
		this.fileDao = fileDao;
	}

	@Override
	public List<FileDto> findListByBSeq(Long b_seq) {
		return fileDao.findByBSeq(b_seq);
	}

	@Override
	public int insert(List<FileDto> files, Long b_seq) {
		return fileDao.insert(files, b_seq);
	}

	@Autowired
	public void create_table() {
		try {
			fileDao.create_file_table(null);
		} catch (Exception e) {

		}
	}

	@Override
	public int imgDelete(long f_seq) {
		// id 기준으로 이미지 데이터 SELECT
		FileDto file = fileDao.findById(f_seq);
		String f_image = file.getF_image();
		
		fileService.delete(f_image);
		fileDao.delete(f_seq);
		return 0;
	}
}