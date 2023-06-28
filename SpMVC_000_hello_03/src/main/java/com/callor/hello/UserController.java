package com.callor.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.service.UserService;

/*
 * client 의 요청을 제일 먼저 수신하여 처리하는 클래스
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	/*
	 * Spring project 에서는 Service 객체를 생성할때
	 * service 클래스의 생성자를 사용하지 않는다.
	 * service 클래스에는 '@Service' Annotation 을 부착하고 
	 * 사용할 service 객체에 '@Autowired' 를 부착한다.
	 * 
	 * IOC(제어의 역전)- DI(클래스의 의존성 주입)
	 */
	@Autowired
	protected UserService userService;
//	public UserController() {
//		userService =  new UserServiceImplV1();
//	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list() {
		List<String> strList = userService.selectAll();
		return strList.get(0);
	}

	// re~ 여기 주소가 중요하다. 겹치면 안됨.
	// RequestMethod.GET : 데이터나 화면을 보여주는 용도
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	// views/user/join.jsp  파일을 Client 로 보내라!
	public String join() {
		return "user/join";
	}
	
	// client 에서 보낸 데이터를 받는 용도
	// RequestMethod.POST : client 에서 데이터를 보내는 용도
	// CRUD 에서 insert 하기 위한 데이터를 받는 용도 
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(Model model) {
		return null;
	}
	
	
	
	
	
}
