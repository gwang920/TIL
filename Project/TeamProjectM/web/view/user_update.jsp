<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
$(document).ready(function(){
	$('#btn_update').on('click', function(){
		var pwd = document.getElementById("pwd").value;
		var pwd_check = document.getElementById("pwd_check").value;
		if(pwd == pwd_check){
			$('#form_update').attr({
				action : 'updateimpl.mc',
				method : 'POST'
			});
			$('#form_update').submit();
			
			
		}else {
			alert("비밀번호가 일치하지 않습니다.");
		}
	});
});
</script>

<!-- <form method="post" action="updateimpl.mc"> -->
<form id="form_update">
	<div class="section-inner">
		<div class="row justify-content-center">
			<div class="col-md-7 wide-col-laptop">
				<div class="title-block animate" data-animate="fadeInUp">
					<span>회원정보 수정 페이지</span>
				</div>
				<div class="contact-section">
					<div class="row">
						<!-- <form id="ajax-contact" method="post" action="#"> -->
						<div class="col-md-6 animate" data-animate="fadeInUp">
							<div class="input-field">
								<input type="text" class="form-control" name="id" id="userid"
									value="${loginInfo.id }" readonly="readonly">
							</div>
							<div class="input-field">
								<c:choose>
									<c:when test="${updateInfo == null }">
										<input type="text" class="form-control" name="pwd" id="pwd"
											value="${loginInfo.pwd }">
									</c:when>
									<c:otherwise>
										<input type="text" class="form-control" name="pwd" id="pwd"
											value="${updateInfo.pwd }">
									</c:otherwise>
								</c:choose>
								<%-- <input type="text" class="form-control" name="pwd" id="pwd"
									value="${loginInfo.pwd }"> --%>
							</div>
							<div class="input-field">
								<input type="text" class="form-control" name="pwd_check"
									id="pwd_check" required placeholder="비밀번호 확인">
							</div>
						</div>
						<div class="col-md-6 animate" data-animate="fadeInUp">
							<div class="input-field">
								<input type="text" class="form-control" name="name" id="name"
									value="${loginInfo.name }" readonly="readonly">
							</div>
							<div class="input-field">
								<c:choose>
									<c:when test="${updateInfo == null }">
										<input type="text" class="form-control" name="hint" id="hint"
											value="${loginInfo.hint }">
									</c:when>
									<c:otherwise>
										<input type="text" class="form-control" name="hint" id="hint"
											value="${updateInfo.hint }">
									</c:otherwise>
								</c:choose>
								<%-- <input type="text" class="form-control" name="hint" id="hint"
									value="${loginInfo.hint }"> --%>
							</div>
							<div class="input-field">
								<c:choose>
									<c:when test="${updateInfo == null }">
										<input type="text" class="form-control" name="hint_answer"
									id="hint_ans" value="${loginInfo.hint_answer }">
									</c:when>
									<c:otherwise>
										<input type="text" class="form-control" name="hint_answer"
									id="hint_ans" value="${updateInfo.hint_answer }">
									</c:otherwise>
								</c:choose>
								
								<%-- <input type="text" class="form-control" name="hint_answer"
									id="hint_ans" value="${loginInfo.hint_answer }"> --%>
							</div>
							<input type="button" class="btn" id="btn_update" value="회원정보 수정">
							<!-- <button class="btn" type="submit" >회원정보 수정</button> -->
						</div>
						<!-- </form> -->
						<div id="form-messages" class="mt-3"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
