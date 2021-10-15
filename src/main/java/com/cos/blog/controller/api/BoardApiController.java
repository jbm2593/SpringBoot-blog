package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.service.BoardService;
import com.cos.blog.service.UserService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board) {
		System.out.println("BoardApiController : btn-board-save 호출됨");
		boardService.글쓰기(board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
}
