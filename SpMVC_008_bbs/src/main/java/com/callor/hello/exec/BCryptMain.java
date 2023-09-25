package com.callor.hello.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class BCryptMain {
	
	public static void main(String[] args) {
		// 내 컴퓨터 운영체제에 등록된 "환경변수"를 추출하는 코드 
		Map<String, String> envList = System.getenv();
		
		// Map 데이터에서 key 만 List 로 추출하기 
//		List<String> envKeys = new ArrayList<>(envList.keySet());
//		
//		for(String env : envKeys) {
//			System.out.printf("%s : %s\n",env, envList.get(env));
//		}
		
		System.out.println(envList.get("callor.com"));
		
		String saltKey = envList.get("callor.com");
		
		// 암호문을 만드는 도구 
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		
		// MD5 와 DES 방식으로 암호화를 하겠다.
		pbe.setAlgorithm("PBEWithMD5AndDES");
		pbe.setPassword(saltKey);
		
		// plan Text 를 암호화 시키는 method 
		String encString = pbe.encrypt("ruru");
		System.out.println(encString);
		
		String s1 = "3gDGgOUIBCon0ZJfnydkOg==";
		String s2 = "gkYNKF6IILM1pUJubuWrrw==";
		String s3 = "sYOuAksFfRwpzKJ7wslOlw==";
		
		// 암호화된 Text 를 복호화(plan Text)로 변환시키는 method
		System.out.println(pbe.decrypt(s1));
		System.out.println(pbe.decrypt(s2));
		System.out.println(pbe.decrypt(s3));

		String savePath = "./src/main/webapp/WEB-INF/spring/properties/db_info.properties";

		try {
			PrintWriter out = new PrintWriter(savePath);
			out.println("username=ruru");
			out.println("password=12345");
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
