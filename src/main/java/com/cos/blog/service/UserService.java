package com.cos.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IOC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) //Select 할 때 트랜젝션 시작,  서비스 종료시에 트랜젝션 종료 ( 정합성)
	public User 로그인(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	@Transactional
	public void 회원수정(int id, User requestUser) {
		System.out.println("Userservice : 회원수정 진입");
		//수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
		//select를 해서 User 오브젝트를 DB로 부터 가져오는 이유는 영속화를 하기 위해서!
		//영속화된 오브젝트를 변경하면 자동으로 DB에 update문을 날려준다.
		//---------위에 주석 적용안함.
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다");
		});
		System.out.println("user: " + user);
		user.setUsername(requestUser.getUsername());
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		System.out.println("user.getUsername: " + user.getUsername());
		System.out.println("user.getPassword: " + user.getPassword());
		System.out.println("user.getEmail: " + user.getEmail());
		
	}
		
}
 