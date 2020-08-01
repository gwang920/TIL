<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<div class="center_page">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('input[type="button"]').click(function(){
		var c = confirm('수정하시겠습니까?');
		if(c == true){
			$('#r_form').attr('method','POST');
			$('#r_form').attr('action','user.do?cmd=userupdateimpl');
			$('#r_form').submit();
		}
	});
});
</script>
<h1>User UPDATE Page</h1>
<form id="r_form">
ID<input type="text" name="id"><br>
PWD<input type="text" name="pwd"><br>
NAME<input type="text" name="name"><br>
<input type="button" value="UPDATE"><br>
</form>
</div>