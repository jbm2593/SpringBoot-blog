<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<input type = "hidden" id = "id" value = "${principal.id}" />
		<div class="form-group">
			<label for="Username">Username</label> 
			<input type="text" value = "${principal.username}" class="form-control" placeholder="Enter Username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" value = "${principal.password}" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" value = "${principal.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
			
		<button id = "btn-update" class="btn btn-primary">회원수정완료</button>
	</form>
</div>

<script src = "/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>