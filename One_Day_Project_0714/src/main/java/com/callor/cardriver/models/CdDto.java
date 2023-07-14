package com.callor.cardriver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CdDto {

	private long cd_seq;
	private String cd_inout;
	private String cd_stdate; // 출발일자
	private String cd_sttime; // 출발시간
	private String cd_stdistance;
	private String cd_ardate;
	private String cd_artime;
	private String cd_ardistance;
	private String cd_place;
	private String cd_price;

}
