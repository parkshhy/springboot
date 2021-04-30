package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //다음에 나오는 클래스인 MyController클래스는 빈으로 등록하겠다는 의미입니다.
public class MyController {

	@Autowired //빈이 생성될때 member1 변수가 참조할 객체를 자동으로 찾아온다.
	Member member1;
	
	@Autowired //빈이 생성될때 printer 변수가 참조할 객체를 자동으로 찾아온다.
	@Qualifier("printerB") //유사한 객체가 printerA,printerB 등 여러개일때 빈의 이름으로 정확하게 지정한다.
	Printer printer;
	
	@Autowired 
	Member member2;
	
	//웹 브라우저에서 사용자가 /로 get방식의 url호출을 하면 다음 라인의 root()메서드를 실행시킨다.
	@RequestMapping("/")
	public @ResponseBody String root() {
		
		//1.Member Bean 가져오기
		member1.print();
		
		//2.PrinterB Bean 가져오기
		member1.setPrinter(printer);
		member1.print();
		
		//3.싱글톤인지 확인
		if(member1==member2) {
			System.out.println("동일한 객체입니다.");
		}else{
			System.out.println("서로 다른 객체입니다.");
		}
		
		
		
		
		
		return "Annotation 사용하기";
	}
	
}
