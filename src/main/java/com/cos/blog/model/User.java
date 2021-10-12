package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴!!
@Entity
//@DynamicInsert //insert 시에 null인 필드를 제외시켜준다.
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 제작된 DB의 넘버링을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100) // 123456 => 해쉬 (비밀번호 암호화, 넉넉하게 크기 잡아두기)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("user")
	//DB는 RoleType이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;  //Enum을 쓰는게 좋다. //ADMIN, USER
	
	@CreationTimestamp // 값을 비워두고 insert해도 시간이 자동 입력
	private Timestamp createdTime;
	
}
