<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="Username">Username</label> 
			<input type="text" class="form-control" placeholder="Enter Username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<div class="form-group form-check">
			<label class="form-check-label"> 
			<input class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>		
	</form>
	<button id="btn-login" class="btn btn-primary">로그인</button>
	<a href = "https://kauth.kakao.com/oauth/authorize?client_id=e05f1c92307d0b24b9d4d02c0cfbf6b5&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height = "38px" src = "/image/kakao_login_button.png"/></a>
</div>

<script src = "/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>