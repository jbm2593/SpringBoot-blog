package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest{
	
	private static final String TAG = "HttpControllerTest:";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234").email("skdj@naver.com").build();
		System.out.println(TAG + "getter:" + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG + "setter : " + m.getUsername());
		
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get요청 : " + m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getEmail();
	}
	
	@PostMapping("/http/post") 
	public String postTest(Member m) {
		return "post요청: "+m.getId()+"," + m.getUsername()+"," + m.getPassword()+"," + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "put요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청";
	}
	
}