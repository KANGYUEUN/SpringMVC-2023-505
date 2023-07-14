package com.callor.bbs.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.config.QualifierConfig;

import lombok.extern.slf4j.Slf4j;

/*
 * V1 클래스에는 fileUp(), filesUp(), delete() method가 있다.
 * 이 method들을 기본적으로 상속 받아서 사용하겠다.
 * 
 * V1클래스에 protected로 선언된 2개의 변수(객체)를 여기에서 상속받아 사용하겠따.
 * 
 * 클래스를 상속받을때 V1클래스의 생성자는 상속받지 않는다.
 */
@Slf4j
// Spring Project 에서 Qualifier : Bean의 id, 이름
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 extends FileServiceImplV1{

	// fileUp-context.xml 에 선언된 2개의 String bean 값을 
	// 사용할 수 있도록 주입해 달라.
	protected final String windowsPath;
	protected final String winPath;
	protected final String macHome;
	protected final String macPath;
	public FileServiceImplV2(ResourceLoader resourece,
			String windowsPath,
			String winPath,
			String macHome,
			String macPath) {
		/*
		 *  < super() method >
		 *  상속받은 클래스의 생성자에게 무언가 전달 할때 사용하는 method, 일종의 전달자. 
		 *  V1클래스의 생성자에게 resource 객체를 전달하여 final로 선언된 2개의 변수(객체)를
		 *  초기화 해달라고 요청하기.
		 */
		super(resourece);
		this.windowsPath = windowsPath;
		this.winPath = winPath;
		this.macHome = macHome;
		this.macPath = macPath;
	}
	/*
	 * V1.fileUp() method를 다시 정의 하겠다.
	 */
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		log.debug("win Path : {}", winPath);
		log.debug("mac Path : {}", macPath);
		
//		String fileUpPath = winPath;
//		File path = new File(macHome);
//		
//		// macHome폴더가 있느냐?
//		if(path.exists()) {
//			fileUpPath = macHome + macPath;
//		}
		
		String fileUpPath = macHome + macPath;
		File path = new File(windowsPath);
		if(path.exists()) {
			fileUpPath = winPath;
		}
		
		// 만약 System 에 Upload 할 path가 없으면 생성하라 
		path = new File(fileUpPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		// 실제 업로드될 파일 이름 
		String fileName = file.getOriginalFilename();
		
		// Java 에서 제공하는 UUID생성하는 코드
		String strUUID = UUID.randomUUID().toString();
		// image.jpg0000-0000-0000 방지하고자
		// UUID 키값을 파일이름 앞에 부착하여 새로운 이름으로 변형, 해킹방지.
		fileName += String.format("%s-%s",strUUID, fileName);
		
		
		
		
		File upLodaFile = new File(fileUpPath, fileName);
		file.transferTo(upLodaFile);
		return fileName;
	}

}
