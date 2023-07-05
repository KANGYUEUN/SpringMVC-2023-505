# Beans 
- Java의 Web Application에서는 생성된(초기화된) 객체를 Bean 이라고한다.
- Spring Project 에서는 일부를 제외하고 객체를 클래스의 생성자를 통하여 만들지 않는다.
```java
	// Spring Project 에서는 잘 사용하지 않는 코드
	myclass myClass = new MyClass()

	// Spring Project 에서 객체를 생성하는 방법
	// 생성된 객체를 Container로 부터 공급(주입)받는 방법

	@Autowired
	protected MyClass myClass;
```
- Spring Project 에서는 사전에 클래스를 객체로 생성하고 Container 에 보관하는 일이 발생하는데,
이때 Container에 보관된 생성된 객체를 `Bean`이라한다.
- Bean 을 생성하는 방법에서 `Spring Bean Confiruration xml`파일에 작성하는 방법과, 최근(Spring 3.x 이상에서)에는 Java class 파일에 작성하는 방법이 사용된다. 
- 또한, @Component Annotaton 을 사용하는 방법이 있다.

## xml을 사용하는 Bean 생성코드 작성
- `/WEB-INF/spring` 폴더에 xml 형태의 파일을 생성하고, 그 파일에 Bean 생성코드를 작성한다.
- Spring Project 초기부터 사용하던 방법이다
- 아직도 많은 프로젝트 들이 이방식으로 만들어 지고 있다.
- `Spring Bean Confiruration` 파일은 STS 에서 지원하는 Wizard 기능을 사용하는 것이 가장 문제를 덜 일으킨다.