package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //다음에 나오는 클래스인 Member 클래스를 빈으로 등록하겠다는 의미이다.
public class Member {

	@Value("홍길동") //빈이 생성될때 name변수의 기본값으로 "홍길동"을 지정한다
	private String name;
	
	@Value("도사") //빈이 생성될때 name변수의 기본값으로 "도사"을 지정한다
	private String nickname;
	
	//해당 클래스의 객체를 찾아와 자동으로 연결한다.  컨테이너에 등록된 빈들 중에서 사용할수 있는 객체를 찾아서 자동으로 연결해준다.
	//빈이 생성될떄 printer 변수가 참조할 객체를 자동으로 찾아온다.
	@Autowired 
	
	//유사한 객체가 여러개일때 빈의 이름으로 정확하게 지정한다.
	@Qualifier("printerA")
	private Printer printer;
	
	public Member(){}
	
	public Member(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	public void setName(String name
			) {
		this.name=name;
	}
	
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	
	}
	public void print() {
		printer.print("Hello "+name+":"+nickname);
	}
	
		
	}


