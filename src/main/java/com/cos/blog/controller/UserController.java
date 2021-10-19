package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.service.BoardService;

@Controller
public class UserController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/logout")
	public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
		model.addAttribute("boards", boardService.글목록(pageable));
//		String sessionId = session.getId();
//		System.out.println("session.getAttribute: " + session.getAttribute("principal"));
//		String abc = session.getAttribute("principal").toString();
//		System.out.print("abc : " + abc.);
		session.removeAttribute("principal");
//		System.out.println("session : " + session.getValue("principal"));
		//WEB-INF/vies/index.jsp
		return "user/logout"; //viewResolver 작동!!
	}
	
	@GetMapping("/userForm")
	public String userForm() {
		return "user/userForm";
	}
}

