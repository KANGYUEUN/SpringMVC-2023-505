# Tile Layout 설정

## JSP 를 위한 Layout 설정 도구 
- tiles 를 설정하기 위한 depindencies 설정
- spring 5.x 이상에서는 tiles-extras만 설정해도 기타 필요한 dependency 모드를 import 해준다.
- 다만 tiles-extras 를 설정 한 후 Maven Dependecies 에 tiles-core 가 함께 import 되었는지 확인할 필요가 있다.
- 만약, tiles-core 가 import 되지 않았을 경우 tiles-extras와 같은 version의 tiles-core 를 설정해 주어야 한다. 

```xml
<properties>
		<tiles-version>3.0.8</tiles-version>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-core</artifactId>
			<version>${tiles-version</version>
		</dependency>


		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>${tiles-version}</version>
		</dependency>


	</dependencies>
```

## InternerResourceViewResolver 와 협력관계 설정
- tiles-context.xml 설정 파일을 appServlet 폴더에 생성한다.
```xml
	<bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"/>
		<property name="order" value="1"/>
	</bean>

```

```xml
<tiles-definitions>
	<definition name="default" template="/WEB-IMF/views/home.hsp">
	
	</definition>
	<definition name="home" extends="default"> 
		

	
	</definition>
</tiles-definitions>
```