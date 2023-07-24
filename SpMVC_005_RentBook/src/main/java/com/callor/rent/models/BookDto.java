package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * STS 
 *  Ctrl + Shift + Y : 모두 소문자
 *   Ctrl + Shift + X : 모두 대문자 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookDto {

	private String b_code;		//도서코드 varchar(13)
	private String b_name;		//varchar(125)
	private String b_author;	//varchar(125)
	private String b_comp;		//varchar(125)
	private int b_year;			//int
	private int b_iprice;		//int
	private int b_rprice;		//int

}
