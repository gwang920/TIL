<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		$('#id_check').on('click', function() {
			var id = document.getElementById("user_id").value;

			if (id == "") {
				alert("아이디를 입력하세요");
				return false;
			}

			$.ajax({
				method : "POST",
				url : "check.mc", //이페이지에서 중복체크를 한다 
				data : {'id' : id},//test.asp에 id 값을 보낸다 
				
				success : function(result) {
					console.log(result);
					if(result == "1"){
						alertify.alert("사용할 수 있는 아이디입니다.");
						var btn_join = document.getElementById('btn_join'); 
						btn_join.disabled = false;
					}else if(result == "0"){
						alertify.alert("이미 존재하는 아이디입니다.");
						var btn_join = document.getElementById('btn_join'); 
						btn_join.disabled = true;
					}
				}
			});

		});
		$('#btn_join').on('click', function() {
			var pwd = document.getElementById("user_pwd").value;
			var pwd_c = document.getElementById("user_pwd_check").value;
			
			if(pwd != pwd_c){
				alertify.alert("비밀번호가 일치하지 않습니다.");
				return;
				
			} else{
				$('#form_join').attr({
					action : 'joinimpl.mc',
					method :  'POST'
					
				});
				$('#form_join').submit();
			}
			
		});
		
	});
</script>
<form id="form_join">
	<div class="section-inner">
		<div class="row justify-content-center">
			<div class="col-md-7 wide-col-laptop">
				<div class="title-block animate" data-animate="fadeInUp">
					<span>회원가입 페이지</span>
				</div>
				<div class="contact-section">
					<div class="row">
						<!-- <form id="ajax-contact" method="post" action="#"> -->
						<div class="col-md-6 animate" data-animate="fadeInUp">
							<div class="input-field">
								<input type="text" class="form-control" name="id" id="user_id"
									required placeholder="아이디">
							</div>
							<div class="input-field">
								<input readonly="readonly" type="text" class="form-control"
									name="id_check" id="id_check" required placeholder="아이디 중복확인">
							</div>
							<!-- <button class="btn" type="submit" id="id_check" style="margin-bottom:30px;">중복확인</button> -->
							<div class="input-field">
								<input type="password" class="form-control" name="pwd"
									id="user_pwd" required placeholder="비밀번호">
							</div>
							<div class="input-field">
								<input type="password" class="form-control"
									name="user_pwd_check" id="user_pwd_check" required
									placeholder="비밀번호 확인">
							</div>
						</div>
						<div class="col-md-6 animate" data-animate="fadeInUp">
							<div class="input-field">
								<input type="text" class="form-control" name="name"
									id="user_name" required placeholder="이름">
							</div>
							<div class="input-field">
								<input type="text" class="form-control" name="hint" id="hint"
									required placeholder="힌트">
							</div>
							<div class="input-field">
								<input type="text" class="form-control" name="hint_answer"
									id="hint_ans" required placeholder="힌트 답변">
							</div>
							<input type="button" class="btn" id="btn_join" disabled="" value="회원가입">
						</div>
						<!-- </form> -->
						<div id="form-messages" class="mt-3"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
