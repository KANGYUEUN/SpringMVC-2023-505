package com.ruru.bookRent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

	public String b_code;	//VARCHAR(6)
	public String b_name;	//VARCHAR(125)
	public String b_auther;	//VARCHAR(10)
	public String b_comp;	//VARCHAR(10)
	public int b_year;		//INT
	public int b_iprice;	//INT
	public int b_rprice; 	//INT

	
}
