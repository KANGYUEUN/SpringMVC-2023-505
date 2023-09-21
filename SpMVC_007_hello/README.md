# SpMVC + Spring Security Project (2023-09-21)
- 보안 서버 프로젝트를 구현 하기 
- login 관련하여 상당부분의 기능을 Security 가 담당하여 대신 처리 해 준다.
- pom.xml 의 SpringSecurity Dependency 에 붙여 넣기 
```xml
<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>${org.springsecurity-version}</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>${org.springsecurity-version}</version>
		</dependency>

```