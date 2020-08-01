# Drag And Drop

#### 명령어 - 이벤트 헨들러

```
ondrag	
요소나 텍스트 블록을 드래그 할 때 발생한다.

ondragend	
드래그를 끝냈을 때 발생한다.

ondragenter	
드래그한 요소나 텍스트 블록을 적합한 드롭 대상위에 올라갔을 때 발생한다. 

ondragexit	
요소가 더 이상 드래그의 직접적인 대상이 아닐 때 발생한다.

ondragleave	
드래그하는 요소나 텍스트 블록이 적합한 드롭 대상에서 벗어났을 때 발생한다.

ondragover	
요소나 텍스트 블록을 적합한 드롭 대상 위로 지나갈 때 발생한다. 

ondragstart	
사용자가 요소나 텍스트 블록을 드래그하기 시작했을 때 발생한다. 

ondrop	
요소나 텍스트 블록을 적합한 드롭 대상에 드롭했을 때 발생한다. 

* 참고사이트https://developer.mozilla.org/ko/docs/Web/API/HTML_%EB%93%9C%EB%9E%98%EA%B7%B8_%EC%95%A4_%EB%93%9C%EB%A1%AD_API
```





# #실습

##### - img파일을 div에 drag & drop

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
div{
	width:300px;
	height:80px;
	border:2px solid red;

}
img{
	width:50px;
}


</style>
<script>

	function cartdrop(e){
	e.preventDefault();
	var src = e.dataTransfer.getData('m');
	console.log(src+ ''+e.target);
	$(e.target).append($('#'+src)); //# -> id
};


function mydrop(e){
	e.preventDefault();
	var src = e.dataTransfer.getData('m');
	console.log(src+ ''+e.target);
	$(e.target).append($('#'+src)); //# -> id
};
function allowdrop(e){

	e.preventDefault();
};
function mydrag(e){

	e.dataTransfer.effectAllowed='move';
	e.dataTransfer.setData('m',e.target.id);  // m이라는 이름으로 e.target.id를 저장하겠다  ex)m1,m2,..	
	console.log(e.target.id);

};
</script>

</head>
<body>
<h1>Drag And Drop</h1>
<h3>Item</h3>
<div ondrop="mydrop(event)" ondragover="allowdrop(event)"> <!-- ondrop이 일어나면 mydrop에 event가 발생하고 -->

	<img src="m1.jpg" id="m1" draggable="true" ondragstart="mydrag(event)">
	<img src="m2.jpg" id="m2" draggable="true" ondragstart="mydrag(event)">
	<img src="m3.jpg" id="m3" draggable="true" ondragstart="mydrag(event)">
	<img src="m4.jpg" id="m4" draggable="true" ondragstart="mydrag(event)">

	
	
</div>


<h3>Cart</h3>
<div ondrop="cartdrop(event)" ondragover="allowdrop(event)">

	
</div>

</body>
</html>
```

