<%@page import="sist.com.model.DiaryBean"%>
<%@page import="sist.com.dao.DiaryDao"%>
<%@page import="sist.com.model.DiaryMember"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="edit.css">
<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

button.btn {
	float: right;
	margin: 50px 0;
}

.jumbotron {
	background-image: url(/Test/image/back3.jpg);
	background-size: cover;
}

.navbar-inverse .navbar-collapse, .navbar-inverse .navbar-form {
	background-color: rgb(246, 202, 107);
}

.navbar-inverse .navbar-nav>.active>a, .navbar-inverse .navbar-nav>.active>a:focus,
	.navbar-inverse .navbar-nav>.active>a:hover {
	background-color: rgb(246, 202, 107);
}

.navbar-inverse {
	background-color: rgb(246, 202, 107);
	border-color: rgb(246, 202, 107);
}

.back {
	color: white;
	font-family: "³ª´®°íµñ";
}

button.btn2 {
	margin: 0;
}

* {
	margin: 0;
	padding: 0;
}

ul, li {
	list-style: none;
}

.select_box, .select_box1 {
	width: 100%;
	height: 50px;
	border: 1px solid #ccc;
	border-radius: 4px;
	line-height: 47px;
	padding-left: 10px;
	background: url('/Test/image/mark.png') no-repeat center right;
	background-position-x: 99%;
}

.select_box img, .select_box1 img {
	width: 57px;
	height: 30px;
	vertical-align: middle;
	padding-right: 20px;
}

.option_wrap, .option_wrap1 {
	width: 100%;
	height: 150px;
	border-left: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-radius: 4px;
	box-shadow: 3px 3px 8px #ccc;
	display: none;
}

.select_op, .select_op1 {
	z-index: 400;
}

.select_op li, .select_op1 li {
	border: 1px solid #ccc;
	float: left;
	width: 25%;
	height: 150px;
	text-align: center;
	border-left: 0;
	border-bottom: 0;
}

.select_op li img, .select_op1 li img {
	width: 100px;
	height: 100px;
	display: block;
	margin: 10px auto;
}
</style>
<script type="text/javascript">
$(document).ready(function(){ 

$('.select_box').click(function(){ 
   $('.option_wrap').toggle(); 
}); 


$('.select_op a').click(function(){ 
   var img = $(this).html(); 
   $('.select_box').html(img); 
   $('.option_wrap').toggle(); 
   return false; 
}); 

$('.select_box1').click(function(){ 
   $('.option_wrap1').toggle(); 
}); 


$('.select_op1 a').click(function(){ 
   var img = $(this).html(); 
   $('.select_box1').html(img); 
   $('.option_wrap1').toggle(); 
   return false; 
}); 

}); 

	function send(){
		var obj=document.frm;
		var feeling=document.getElementById('feeling').innerText;
		var weather=document.getElementById('weather').innerText;
		
		var job=document.getElementById('job').innerText;
		
		if(feeling=='FEELING SELECT'||weather=='WEATHER SELECT'){
			alert('DATA CHECK!');
			return false;
		}else{
			obj.feeling.value=feeling;
			obj.weather.value=weather;
		}
		var obj=document.frm;
		obj.submit();
	}
</script>
</head>
<body>
<%
	String job=(request.getParameter("job")==null?"":request.getParameter("job"));
	String id = request.getParameter("id");
	DiaryMember bean = DiaryDao.passCheck(id);
	DiaryBean bean2=new DiaryBean();
	String name = bean.getName();
	int no=bean.getNo();
	int datano=-1;
	
	if(job.equals("modify")){
		datano=Integer.parseInt(request.getParameter("no"));//°Ô½Ã¹°¹øÈ£
		bean2=(DiaryBean)DiaryDao.selectListDiaryInfo(datano);
	}
%>
	<div class="jumbotron">
		<div class="container text-center back">
			<h1>Diary</h1>
			<span id="sp" style="display: none"><%=id%></span>
			<span id="sp1" style="display: none"><%=datano%></span>
			<span id="job" style="display: none"><%=job==null?"":job %></span>
			<p><%=name == null ? "" : name%>
				´Ô, ÇÏ·ç¸¦ ¸¶¹«¸®ÇÏ¼¼¿ä
			</p>
		</div>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Daily Note</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Diary</a></li>
					<li><a href="#">Weekly</a></li>
					<li><a href="#">Month</a></li>
					<li><a href="#">My Board</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
		</div>
	</nav> 
	<div class="container">
		<%
			if(job.equals("modify")){
				%>
			<form action="editProcess.jsp?job=modify&no=<%=datano %>&id=<%=id %>" method="post" name="frm" enctype="multipart/form-data">
				<%
			}else{
				%>
			<form action="editProcess.jsp?no=<%=no %>&id=<%=id %>" method="post" name="frm" enctype="multipart/form-data">
				<%
			}
		%>
			<div class="form-group">
				<label for="inputdefault">DATE</label> <input class="form-control"
					id="date" type="date" name="date" value="<%=bean2.getDatediary()==null?"":bean2.getDatediary()%>">
					<input type="hidden" name="no" value="0">
			</div> 
			<div class="form-group">
				<label for="inputdefault">TITLE</label> <input class="form-control"
					id="title" type="text" name="title" value="<%=bean2.getTitle()==null?"":bean2.getTitle()%>">
			</div>
			<div class="form-group">
				<label for="inputsm">CONTENTS</label>
				<textarea class="form-control input-lg" rows="20" cols="160"
					style="resize: none;" name="contents"><%=bean2.getContents()==null?"":bean2.getContents() %></textarea>
			</div>
			<div class="form-group">
				<label for="inputsm">FEELING</label>			
				<input type="hidden" name="feeling">
				<div class="select_box" id="feeling">
				<%
					if(bean2.getFeeling()!=null){
						%>
						<img src="/Test/image/<%=bean2.getFeeling().toLowerCase().trim()%>.png">
						<%=bean2.getFeeling()%>
						<%
					}else{
						%>
						FEELING SELECT
						<%
					}
				%>
				</div>
				
				<div class="option_wrap">
					<ul class="select_op">
						<li><a href=""><img src="/Test/image/happy.png">HAPPY</a></li>
						<li><a href=""><img src="/Test/image/good.png">GOOD</a></li>
						<li><a href=""><img src="/Test/image/angry.png">ANGRY</a></li>
						<li><a href=""><img src="/Test/image/sad.png">SAD</a></li>
					</ul>
				</div>
			</div>
			<div class="form-group">
				<label for="sel2">WEATHER</label>
				<div class="select_box1" id="weather">
					<%
					if(bean2.getWeather()!=null){
						%>
						<img src="/Test/image/<%=bean2.getWeather().toLowerCase().trim()%>.png">
						<%=bean2.getWeather()%>
						<%
					}else{
						%>
						WEATHER SELECTT
						<%
					}
				%>
				</div>
				<div class="option_wrap1">
					<ul class="select_op1">
						<li><a href=""><img src="/Test/image/sunny.png">SUNNY</a></li>
						<li><a href=""><img src="/Test/image/cloud.png">CLOUD</a></li>
						<li><a href=""><img src="/Test/image/rain.png">RAIN</a></li>
						<li><a href=""><img src="/Test/image/rainbow.png">RAINBOW</a></li>
					</ul>
				</div>
			</div>
			<input type="hidden" name="weather">
			<div class="form-group">
				<label for="sel2">IMAGE</label> <input type="file" name="file">
			</div>

			<!-- ³¯¾¾ -->
			<button type="button" class="btn btn-success" onclick="send()">SEND</button>
		</form>
	</div>

</body>
<script type="text/javascript">
  	document.getElementById('dateInput').valueAsDate=new Date();
  </script>
</html>
