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
public class UserDto {

	public String u_code;	//VARCHAR(6)
	public String u_name;	//VARCHAR(10)
	public String u_tel;	//VARCHAR(15)
	public String u_addr;	//VARCHAR(125)

}
