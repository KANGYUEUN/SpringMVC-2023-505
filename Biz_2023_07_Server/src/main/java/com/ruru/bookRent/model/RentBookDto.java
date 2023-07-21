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
public class RentBookDto {

	public long rent_seq;			//BIGINT
	public String rent_date;		//VARCHAR(10)
	public String rent_return_date;	//VARCHAR(10)
	public String rent_dcode;		//VARCHAR(6)
	public String rent_ucode;		//VARCHAR(6)
	public String rent_return_yn;	//VARCHAR(1)
	public int rent_point;			//INT

}
