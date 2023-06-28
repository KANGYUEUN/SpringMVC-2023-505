# Spring Project 의 " Servlet "
- 현재 project 에서 사용하는 WAS(Web Application Server) 는 Tomcat 9 이다.
- Tomcat 버전이 9. X 까지는 하위 호환을 유지하고 있어서 버전에 따른 문제가 거의 없었다.
- Tomcat 버전이 10.X 가 되면서 내부 스팩이 완전 변경 되었다.
- Tomcat 9. 까지는 JavaEE
- Tomcat 10.X 는 JakartaEE 스팩으로 변경 되었다.
- project 에서 사용하는 Tomcat 은 9.X 버전이지만, 이 버전은 하위 호환이 되기 때문에 Servlet version 과 크게 상관없이 작동된다.
- 단 Tomcat 10.X 를 사용하려면 project 를 상당히 많이 변경해야 하고, 변경하는 과정에서 여러 문제를 일으킬수 있다.


## 입력 form 만들기시 주의사항~
- 입력화면은 반드시 `form` 으로 감싸야 한다.
- 특별한 경우가 아니면 method는 `POST`로 지정한다.
- action 은 서보로 데이터를 보낼때 사용할 URL(URI)이다.
- 만약 action dmf 생략하면, 입력화면을 보여줄때 사용한 URI 가 자동으로 설정된다.
- form 으로 감싼 button 은 자동으로 submit event 가 설정된다.
- submit : 입력화면에서 입력한 데이터를 서버로 전송하는 event 이다.