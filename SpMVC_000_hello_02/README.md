# Spring Project
- Spring Legacy Project > Spring MVC Project 생성
- views/home.jsp 삭제후 다시 작성

## pom.xml 수정
- java version을 11 로 변경
- spring framework 5.2.24로 변경
- slf4j 1.7.36 으로 변경

- maven - compliler - plugin java 버전 property 로 변경
- lombok 설정
- logback 설정

## Dto 데이터 클래스 생성하기 
- Spring framework 에서 사용하는 데이터 클래스는 모든 변수를 `private`으로 선언한다.
- 따라서, 변수에 접근하기 위해 `getter, setter method`를 필수로 생성해야 한다.
- 두개의 생성자, toString() 재정의
- lombok 을 사용하여 자동 생성한다.


## Service 클래스 생성하기
- Service 클래스는 기본적으로 Service interface를 만들고 interface 를 Impl 하여 작성한다.
- Service 클래스에 @Service Annotation을 부착한다.
- @Service Annotation 이 부착된 클래스는 Spring Framwork 에서 자동으로 객체를 준비하여 가지고 있다.
- @Autowired 가 부착된 곳으 발견하면 자동으로 객체를 '주입'하여 사용할 준비를 해준다. 
