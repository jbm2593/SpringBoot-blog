<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<a href = "/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
	<button id="btn-delete" class="btn btn-danger">삭제</button>
	<br /> <br />
	<div>
		<div>
			글 번호: <span id="id"><i>${board.id} </i></span> 
			작성자: <span><i>${principal.username} </i></span>
		</div>
		<br />
		</div>
		<div>
			<h3>${board.title}</h3>
		</div>
		<hr />
		<div>
			<div>${board.content}</div>
		</div>
		<hr />

   </div>


	<script src="/js/board.js"></script>
	<%@include file="../layout/footer.jsp"%>