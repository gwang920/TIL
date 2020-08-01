<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		var findInfo = '';

		$('#btn_find').on('click', function() {
			if (findInfo != '') {
				var hint_result = $('#find_hint_answer').val();
				
				if(hint_result == findInfo.hint_answer) {
					alert(findInfo.pwd);
					location.href = "#slide05";
				}else{
					alert("힌트 답변이 틀렸습니다.");
				}
			}

			else {
				var id = $('#find_id').val();
				var name = $('#find_name').val();
				console.log(id + name);
				$.ajax({
					method : "POST",
					url : "find.mc",
					data : {
						'id' : id,
						'name' : name
					},
					success : function(result) {
						console.log(result);

						if (result == "0") {
							alert("사용자가 존재하지 않습니다.");
							return;
						} else {
							findInfo = result;

							$('#find_hint').val(result.hint);
							$('#btn_find').val("비밀번호 조회");

							/* location.href = "index.mc"; */
						}
					}
				});
			}

		});
	});
</script>
<div class="section-inner">
	<div class="row justify-content-center">
		<div class="col-md-7 wide-col-laptop1">
			<div class="title-block animate" data-animate="fadeInUp">
				<span>비밀번호 찾기 페이지</span>
			</div>

			<!-- <form id="form_login" action="loginimpl.mc"> -->
			<form id="form_login">
				<div class="input-field">
					<input type="text" class="form-control" name="find_id" id="find_id"
						required placeholder="아이디">
				</div>
				<div class="input-field">
					<input type="text" class="form-control" name="find_name"
						id="find_name" required placeholder="이름">
				</div>

				<!-- 힌트 -->
				<div class="input-field">
					<input type="text" class="form-control" name="find_hint"
						id="find_hint" required placeholder="힌트">
				</div>

				<!-- 힌트 답변 -->
				<div class="input-field">
					<input type="text" class="form-control" name="find_hint_answer"
						id="find_hint_answer" required placeholder="힌트 답변">
				</div>

				<div class="input-field">
					<input type="button" class="btn" id="btn_find" value="힌트 조회">
				</div>
			</form>
		</div>
	</div>
</div>