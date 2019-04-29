<%@page import="java.util.HashMap"%>
<%@page import="sist.com.model.DiaryBean"%>
<%@page import="sist.com.model.DiaryMember"%>
<%@page import="sist.com.dao.DiaryDao"%>
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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
	margin: 50px 380px 50px 0;
}

.jumbotron {
	background-image: url(/Test/image/back3.jpg);
	background-size: cover;
}

.back {
	color: white;
	font-family: "나눔고딕";
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

.btn1 {
	float: right;
	margin: 0;
}

.btn-group
>
.btn1
:first-child
:not
 
(
:last-child
 
)
:not
 
(
.dropdown-toggle
 
)
{
/*   border-top-left-radius: 0;
    border-bottom-left-radius: 0; */
}
.btn-group>.btn1:first-child {
	margin-left: 0;
}

.btn-group>.btn1:nth-child(2) {
	border-radius: 0;
}

.btn1:hover, .btn1:focus, .btn1.focus {
	color: #333;
	text-decoration: none;
}

.btn1 {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 20px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}

.col-md-offset-2 {
	margin-left: 0;
}

.col-md-offset-2 {
	margin-left: 0;
}

.col-md-8 {
	width: 100%;
}

@import
	url("http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css")
	;

body {
	background-color: #FAFAFA !important;
}

.panelD {
	margin: 20px 0px 20px 0px;
}

.panelD .panel-heading, .panelD .panel-footer {
	background-color: #fff !important;
	overflow: hidden;
}

.panel-image img.panel-image-preview {
	width: 100%;
	border-radius: 4px 4px 0px 0px;
}

.panel-heading ~ .panel-image img.panel-image-preview {
	border-radius: 0px;
}

.panel-heading .list-inline {
	margin: 0px 0px 0px -5px !important;
	float: right;
}

.panel-body {
	display: block;
}

.panel-body blockquote {
	margin: 10px 0 10px;
}

.tagz {
	margin: 15px 0px 0px;
	display: block;
}

.tagz a {
	cursor: pointer;
	color: rgb(100, 100, 100);
}

.panel-image ~ .panel-footer a {
	padding: 0px 10px;
	color: rgb(100, 100, 100);
}

.panel-image ~ .panel-footer span {
	color: rgb(100, 100, 100);
}

.panel-footer .list-inline {
	margin: 0 0 0 -15px !important;
}

.panel-image.hide-panel-body ~ .panel-body {
	height: 0px;
	padding: 0px;
}

/*==========  Mobile First Method  ==========*/

/* Custom, iPhone Retina */
@media only screen and (max-width : 320px) {
	.level-line-up {
		position: relative;
		top: -4px;
	}
}

/* Extra Small Devices, Phones */
@media only screen and (max-width : 480px) {
	.level-line-up {
		position: relative;
		top: -4px;
	}
}

/* Small Devices, Tablets */
@media only screen and (min-width : 480px) and (max-width : 768px) {
	.level-line-up {
		position: relative;
		top: -4px;
	}
}

}
.col-md-3 {
	width: 0;
}

.col-md-6 {
	width: 101%;
}

.panel-image img.panel-image-preview {
	width: 70%;
	display: block;
	margin: 50px auto;
}

button.btn {
	float: left;
	margin: 0
}

.btn-group, .btn-group-vertical {
	float: right;
}
</style>
<script type="text/javascript">
	function list(){
		var id=document.getElementById("sp").innerText;
		document.location.href="list.jsp?id="+id;
	}
	
	function deleteData(){
		
		if (confirm('하루의 기록을 삭제하시겠어요? 다시 한번 생각해주세요')) {
			var no=document.getElementById("sp2").innerText;//게시물번호
			var id=document.getElementById("sp").innerText;
			document.location.href="deleteProcess.jsp?no="+no+"&id="+id;
		    return false;
		} else {
		   return false;
		}
		
	}
	
	function modifyData(){
		var id=document.getElementById("sp").innerText;//id
		var no=document.getElementById("sp2").innerText;//no
		document.location.href="edit.jsp?job=modify&no="+no+"&id="+id;
	}
</script>
</head>
<body>
<%
	String id = request.getParameter("id");
	int no=Integer.parseInt(request.getParameter("no"));
	DiaryMember bean = DiaryDao.passCheck(id);
	String name = bean.getName();
	HashMap<String,Object>map=new HashMap<String,Object>();
	
	DiaryBean info=DiaryDao.selectListDiaryInfo(no);
%>
	<div class="jumbotron">
		<div class="container text-center back">
			<h1>Diary</h1>
			<span id="sp" style="display: none"><%=id%></span>
			<span id="sp1" style="display: none"><%=bean.getNo()%></span>
			<span id="sp2" style="display: none"><%=no%></span>
			<p><%=name == null ? "" : name%>
				님, 하루를 마무리하세요
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
					<li><a href="login.jsp"><span
							class="glyphicon glyphicon-user"></span> LOGOUT</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">

			<div class="col-md-3"></div>
			<div class="col-md-6">
			<%
				if(info.getFileName()!=null){
			
			%>
				<div class="panel panel-default panelD">
					<div class="panel-heading">
						<img src="/Test/image/<%=info.getFeeling().toLowerCase() %>.png"
							style="float: left; margin-right: 10px; width: 36px;">
						<h6 style="float: left; font-size: 16px"><%=info.getTitle() %></h6>
						<div class="btn-group">
							<ul class="list-inline btn-group">
								<li class="pull-right" style="padding-right: 0;"><button
										type="button" class="btn btn-warning btn-filter"
										data-target="pendiente" onclick="list()">List</button></li>
								<li class="pull-right" style="padding-right: 0;"><button
										type="button" class="btn btn-danger btn-filter"
										data-target="cancelado" onclick="deleteData()">Delete</button></li>
								<li class="pull-right" style="padding-right: 0;"><button
										type="button" class="btn btn-success btn-filter"
										data-target="pagado" onclick="modifyData()">Modify</button></li>
							</ul>
						</div>
					</div>
					<div class="panel-image">
						<img
							src="/Test/projectBoard/Upload/<%=info.getFileName()%>"
							class="panel-image-preview" />
					</div>
					<div class="panel-body">
						<blockquote>
							<p><%=info.getContents() %></p>
						</blockquote>
						<span class="tagz">Weather <img src="/Test/image/<%=info.getWeather().toLowerCase() %>.png"
							style="width: 3%; margin-left: 10px"></a></span>
					</div>
					<div class="panel-footer">
						<ul class="list-inline clearfix">
							<li class="col-sm-4 col-md-4 col-lg-4" style="float: right;"><a
								class="pull-right" href=""><span class="fa fa-bomb"></span>
									<%=info.getDatediary() %></a></li>
						</ul>
					</div>
				</div>
				<%
				}else if(info.getFileName()==null){
					
				%>
				<!-- 이미지 없을 뙈 -->
				<div class="panel panel-default panelD">
					<div class="panel-heading">
						<img src="/Test/image/<%=info.getFeeling().toLowerCase() %>.png"
							style="float: left; margin-right: 10px; width: 36px;">
						<h6 style="float: left; font-size: 16px"><%=info.getTitle() %></h6>
						<div class="btn-group">
							<ul class="list-inline btn-group">
								<li class="pull-right" style="padding-right: 0;"><button
										type="button" class="btn btn-warning btn-filter"
										data-target="pendiente" onclick="list()">List</button></li>
								<li class="pull-right" style="padding-right: 0;"><button
										type="button" class="btn btn-danger btn-filter"
										data-target="cancelado" onclick="deleteData()">Delete</button></li>
								<li class="pull-right" style="padding-right: 0;"><button
										type="button" class="btn btn-success btn-filter"
										data-target="pagado" onclick="modifyData()">Modify</button></li>
							</ul>
						</div>
					</div>
					
					<div class="panel-body">
						<blockquote>
							<p><%=info.getContents() %></p>
						</blockquote>
						<span class="tagz">Weather <img src="/Test/image/<%=info.getWeather().toLowerCase() %>.png"
							style="width: 3%; margin-left: 10px"></a></span>
					</div>
					<div class="panel-footer">
						<ul class="list-inline clearfix">
							<li class="col-sm-4 col-md-4 col-lg-4" style="float: right;"><a
								class="pull-right" href=""><span class="fa fa-bomb"></span>
									<%=info.getDatediary() %></a></li>
						</ul>
					</div>
				</div>
				<%

				}
				%>
			</div>
			<div class="col-md-3"></div>

		</div>
	</div>
</body>
</html>
