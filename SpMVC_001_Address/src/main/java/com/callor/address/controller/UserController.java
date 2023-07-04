package com.callor.address.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.address.models.UserDto;
import com.callor.address.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	protected final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home() {
		return null;
	}
	
	
	/*
	 *  <  error 매개변수 >
	 *  POST/user/login 에서 username 과 password가 틀릴경우
	 *  redirect 하면서 전달하는 error 값을 받기 위한 매개변수
	 *  메뉴에서 login을 실행하면 이 데이터는 null이다. 
	 *  error 매개변수 값은 그대로 model 에 담아서
	 *  login.jsp로 보낸다.  
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("ERROR",error);
		model.addAttribute("BODY","LOGIN");
		return "home";
	}
	
	/*
	 *  < HttpSession : Servlet Session >
	 * Java 기반 MVC 프로젝트에서 가장 많이 사용하는 Session 관리 객체 
	 * method의 매개변수에 HttpSession 객체를 설정하면 
	 * Spring 에서는 DespatcherServlet이 httpSession객체를 생성하여 
	 * method의 매개변수로 전달 해 준다.
	 * 
	 * httpSession객체가 생성되는 순간, 이 프로젝트는 Session 관리자가 생성된다.
	 * 
	 * Session은 http 프로토콜 에서 Client 와 Server 간에 암묵적으로 
	 * 데이터를 공유하는 통로가 만들어 진다.
	 * 
	 * 이 Session 에 데이터를 저장하면 
	 * 그 데이터는 model 에 데이터를 담는것과 똑같이 사용이 가능하며,
	 * 일정 조건 하에 데이터는 계속해서 유지 된다.
	 * 
	 * model 에 데이터를 담는것과 차이는 model 데이터는 한번 view와 랜더링을 수행한후 소멸된다.
	 * Session데이터는 특별한 조건 하에서는 계속 유지되는 차이가 있다. 
	 * 또한 Session데이터가 필요 없을 경우 이 데이터를 강제 소멸 시켜야 한다. 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserDto userDto, HttpSession httpSession) {
		
		String result = userService.userLogin(userDto);
		if(result.equals("OK")) {
			/*
			 * add() : 무한히 데이터를 추가 할 수 있다 .
			 * set() : 제한적으로 데이터를 추가 하는 것이 좋다.
			 * httpSession 에 set한 Attribute는 
			 * model 에 add한 attribute 와 view에서 사용하는 것은 거의 동일하다. 
			 */
			httpSession.setAttribute("USER", userDto);
			return "redirect:/";
		} else {
			return "redirect:/user/login?error=" + result; 
		}
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage() {
		return null;
	}
	
	/*
	 * Controller.method() 에서 response 결과인 view이름을 문자열로 return 하면
	 *  /WEB-INF/views/ 폴더에서 파일을 찾아 rendering한 후 응답을 한다. 
	 *  
	 *  그런데, 문자열이 아니고 null을 return 하면 
	 *  이 method 가 호출된 requestMappting 주소가 view 파일 이름을 대신하게 된다. 
	 */

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		// Session에 저장된 데이터를 clear
		httpSession.setAttribute("USER", null);
		// Session 자체를 모두 소멸 
		httpSession.removeAttribute("USER");
		
		return "redirect:/?message=LOGOUT";
//		return null;
	}



}
