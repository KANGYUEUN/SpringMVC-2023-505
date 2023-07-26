package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 *  < Data Class : Dto(Data Transfer Object), VO(Value Object) >
 *  Dto : CRUD 를 위한 것(getter,setter)
 *  		실제 데이터가 저장된 table 과 1:1로 칼럼이 매칭되는것	
 *  
 *  VO :  SELECT를 위한 것(getter) - 데이터를 한번 저장하면 변경 할 수 없다. 읽기전용이다.
 *  	 JOIN 되는 SELECT 문의 결과를 DB 로부터 가져와서 데이터를 저장하는 class 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RentBookVO {

	private long rent_seq;
	
	private String rent_bcode; 	//<th>도서코드</th>
	private String b_name; 		//<th>도서명</th>
	private String b_comp;		//<th>출판사</th>

	private String rent_mcode; 		//<th>회원코드</th>
	private String m_name;			//<th>회원명</th>
	private String m_tel;			//<th>전화번호</th>

	private String rent_date;			//<th>대출일</th>
	private String rent_return_date;	//<th>반납일</th>
	private String rent_return_yn;		//<th>도서반납여부</th>
	private int rent_price;				//<th>대여금액</th>
	
	private int rent_point;				//<th>포인트</th>
	
	
	
}
