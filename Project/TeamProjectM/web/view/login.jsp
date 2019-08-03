<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(document).ready(function(){
	$('#btn_login').on('click', function(){
		var id = document.getElementById("login_id").value;
		var pwd = document.getElementById("pwd").value;
		$.ajax({
			method : "POST",
			url : "loginimpl.mc", 
			data : {'id' : id,
					'pwd' : pwd },
			success : function(result){
				console.log(result);
				if(result == "0"){
					alert("아이디나 비밀번호가 일치하지 않습니다.");
					return;
				}else {
					location.href="index.mc";
				}
			}
		});
	});
});
</script>
<div class="section-inner">
	<div class="row justify-content-center">
		<div class="col-md-7 wide-col-laptop1">
			<div class="title-block animate" data-animate="fadeInUp">
				<span>로그인 페이지</span>
			</div>

			<!-- <form id="form_login" action="loginimpl.mc"> -->
			<form id="form_login">
				<div class="input-field">
					<input type="text" class="form-control" name="login_id"
						id="login_id" required placeholder="아이디">
				</div>
				<div class="input-field">
					<input type="password" class="form-control" name="pwd" id="pwd"
						required placeholder="비밀번호">
				</div>
				<div class="input-field">
					<input type="button" class="btn" id="btn_login" value="로그인">
				</div>
				<div class="input-field">
					<input type="button" class="btn" id="btn_findPwd" onclick="location.href='#slide07'" value="비밀번호 찾기">
				</div>
				<!-- form.js 에서 아이디, 비번 확인해서 메세지 던지기. -->
			</form>
			<div id="form-messages" class="mt-3"></div>
		</div>
	</div>
</div>