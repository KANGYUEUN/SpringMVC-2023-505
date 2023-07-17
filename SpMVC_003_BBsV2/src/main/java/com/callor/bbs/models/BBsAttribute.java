package com.callor.bbs.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.ModelAttribute;

/*
 *  < 날짜 클래스 >
 *  자바에서는 전통적으로 Date, Calender 와 같은 날짜(시간)관련 클래스를 가지고 있다.
 *  이 클래스들은 날짜 값에서 여러가지 이슈들이 많이 발견 되었다.
 *  또한 자바가 업그레이드 되는 동안 날짜관련 여러 문제 해결 못함.
 *  
 *  Java 1.8 이후 LocalDate, LocalTime, LocalDateTime 으로 날짜, 시간 관련 클래스가
 *  새롭게 많들어 졌다. 최신 자바에서는 Local** 클래스르 통해 날짜 관련 문제를 해결하도록 한다.
 *  
 *  특히, DB 와 연동되는 프로젝트에서 날짜, 시간 관련 데이터를 취급 하는데
 *  Java 와 DB Server 간에 데이터 교환 문제를 일으키기도 한다. 
 *  보통 DB 와 연동 할때 날짜 형식의 데이터를 사용 하지 않고 
 *  문자열로 변환하여 사용한다. 
 */
public class BBsAttribute {

	@ModelAttribute("BBS")
	public BBsDto getBBsDto() {
		BBsDto bbsDto  = new BBsDto();
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar =  Calendar.getInstance();
		
		// 현재 날짜, 시간 getter 하기 
		LocalDateTime localDateTime = LocalDateTime.now();	
		
		// 날짜, 시간 값을 문자열로 변환하기 위한 pattern 생성.
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH::mm:ss");
		
		// 날짜, 시간 형식의 데이터를 문자열로 변환.
		String strDate = localDateTime.format(dateFormatter);
		String strTime = localDateTime.format(timeFormatter);
		
		bbsDto.setB_date(strDate);
		bbsDto.setB_time(strTime);
		
		return bbsDto;
	}
}
