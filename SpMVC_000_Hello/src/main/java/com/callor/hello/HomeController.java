package com.callor.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.callor.hello.models.AddressDto;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 33);
		model.addAttribute("tel", "010-1111-1111");
		return "home";
	}

	@RequestMapping(value = "/hello")
	public String hello(Model model) {
		AddressDto addrDto = new AddressDto();
		addrDto.setName("성춘향");
		addrDto.setTel("010-222-2222");
		addrDto.setAge(16);
		addrDto.setAddress("전라북도 남원시");

		model.addAttribute("ADDR", addrDto);

		// WEB-INF/views/hello.jsp 를 찾아서 rendering 해 달라.
		return "hello";
	}

	/*
	 * @RequestMapping(value="/user") : request 에 응답하도록 설정 리스트 선언하고 주소 추가
	 * addressDto = new AddressDto(); : 객체마다 DTO를 새롭게 셋팅 해야 리스트에 추가가 된다. 
		addressDto.setName("이몽룡");
	 */
	@RequestMapping(value = "/user")
	public String user(Model model) {
		List<AddressDto> addrList = new ArrayList<AddressDto>();

		AddressDto addressDto = new AddressDto();
		addressDto.setName("홍길동");
		addressDto.setAge(33);
		addressDto.setTel("010-1111-1111");
		addressDto.setAddress("서울 특별시 ");
		addrList.add(addressDto);
		
		addressDto = new AddressDto();
		addressDto.setName("이몽룡");
		addressDto.setAge(22);
		addressDto.setTel("010-2222-1111");
		addressDto.setAddress("부산특별시 ");
		addrList.add(addressDto);

		addressDto = new AddressDto();
		addressDto.setName("이몽룡");
		addressDto.setName("성춘향");
		addressDto.setAge(16);
		addressDto.setTel("010-3333-1111");
		addressDto.setAddress("광주특별시 ");
		addrList.add(addressDto);

		for (AddressDto dto : addrList) {
			System.out.println(dto.toString());
		}
		
		model.addAttribute("ADDRS", addrList);
		return "user2";
	}

}
