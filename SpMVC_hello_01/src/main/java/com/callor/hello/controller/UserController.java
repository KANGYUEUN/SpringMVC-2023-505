package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;

import lombok.extern.slf4j.Slf4j;

/*
 * class 를 만들고 @Controller 라는 Annotation을 부착하면 
 * Spring Framework 에서 자동으로 이 클래스에 Controller기능을 부여한다.
 * 
 * Controller class 는 Web Application 에서 Request를 가장 먼저 수신하난 객체이다.
 * 이 클래스에 method 를 선언하고 @Request Annotation 을 부착하면 Web의 URL(URI) 를 처리하는 method가 된다.
 */
@Slf4j
@Controller
public class UserController {

	// http://localhost:8080/hello/user/login 으로 Request를 하면 처리할 method라는 선언.
	
	// method = 'GET'
	// 브라우저의 주소창에 URL 을 입력하여 요청
	// a tag의 href 에 주소를 연결하여 요청
	// 일반적인 (결과)화면을 요청할때 사용한다.
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	// method = 'POST'
	// form 으로 감싼 input data 를 보낼때 주로 사용
	// form tag 의 method속성을 반드시 'POST'로 지정해야 한다.
	// 데이터를 서버로 보낼때 사용하는 Request
	
	// client(web) 에서 보낸 username 변수, password 변수에담긴 데이터를 받을때는
	// method의 매개변수를 설정해 주면 된다. (<form> 의 데이터를 그대로 받을수 있음)
	@RequestMapping(value = "/user/login", method=RequestMethod.POST)
	public String login(String username, String password, Model model) {
		model.addAttribute("name", username);
		model.addAttribute("password", password);
		return "login_ok";
	}
	
	
	@RequestMapping(value = "/user/join", method=RequestMethod.GET)
	public String join() {
		/*
		 *  method 에서 String 값을 return 하면
		 *  views 폴더에서 해당 String 의 jsp 파일을 찾아 랜더링한다.
		 *  method  에서 null값을 return 하면 
		 *  views 폴더에서 requestMapping과 같은 path위치에서 jsp 파일을 찾는다.
		 *  /views/user/join.jsp 를 찾는다.
		 */
		return null;
	}
	
	/*
	 * Spring 에서 web 에서 여러가지 데이터를 받을 경우
	 * 모든 변수를 매개변수로 선언하지 않고,
	 * DTO 클래스를 통해 Dto 클래스 , 객체를 매개변수로 선언하여 
	 * @ModelAttribute 속성을 지정하여 사용한다.
	 * 
	 *  Spring framework 의 도구들이 
	 *  form 에서 전달된 데이터를 Dto 객체에 자동으로 담아준다.
	 *  
	 *  " Java 코딩에서 method에 전달할 데이터(변수) 가 2개를 초과하면 무조건 Dto를 만든다." 
	 *  
	 *   < @ModelAttribute 속성 >
	 *   현재 Spring framework 에서는 선택사항 이지만 
	 *   오래된 Spring framework 에서는 필수 항목이다.
	 *   
	 *   그래서 선택 사항이지만 부착하는 습관을 들이자.
	 *   
	 */
	@RequestMapping(value = "/user/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserDto user, Model model) {
		
		// 콘솔 출력시 아래 코드 사용 금지 
		System.out.println(user.toString());
		
		// Spring Project 에서는 Console에 출력하기 
		// logback 을 사용하여 콘솔에 확인 메시지 출력하기 
		log.debug(user.toString());
		
		model.addAttribute("USER", user);
		return "user/join_ok";
	}
	
	
	
	
}
