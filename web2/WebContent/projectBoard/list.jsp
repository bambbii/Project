<%@page import="sist.com.model.DiaryBean"%>
<%@page import="java.util.List"%>
<%@page import="sist.com.dao.DiaryDao"%>
<%@page import="sist.com.model.DiaryMember"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
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
<meta charset="utf-8">
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

.col-md-offset-2 {
    margin:0;
}
.col-md-8 {
    width: 100%;
}

</style>
<script type="text/javascript">
	function writeData(){
		
		var id=document.getElementById("sp").innerText;
		document.location.href="edit.jsp?id="+id;
	}
</script>
</head>
<body>
<%
	String id = request.getParameter("id");
	DiaryMember bean = DiaryDao.passCheck(id);
	String name = bean.getName();
	int no=bean.getNo();//회원번호
	List<DiaryBean>list=DiaryDao.selectListDiary(no);
%>
	<div class="jumbotron">
		<div class="container text-center back">
			<h1>Diary</h1>
			<span id="sp" style="display: none"><%=id%></span>
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

			<section class="content">
				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="pull-right">
								<div class="btn-group">
									<input type="button" class="btn btn-success btn-filter" style="margin:0 0 17px 0;"
										data-target="pagado" onclick="writeData()" value="Write">
								</div>
							</div>
							<div class="table-container">
								<table class="table table-filter">
									<tbody>
									<%
										if(list.size()==0){
											%>
											<tr data-status="pagado">
											<td>
												<div class="media">
													<div class="media-body">
														<p class="summary" style="text-align: center;margin-top: 55px; font-family: '나눔고딕'; color: #335; font-size: 18px;">
															<%=name %> 님의 첫 번째 하루를 작성해보세요!
														</p>
													</div>
												</div>
											</td>
										</tr>
											<%
											
										}
										for(int i=0; i<list.size();i++){
									%>
										<tr data-status="pagado">
											<td><a href="javascript:;" class="star"> <i
													class="glyphicon glyphicon-star"></i>
											</a></td>
											<td>
												<div class="media">
													<a href="#" class="pull-left"> <img
														src="/Test/image/<%=list.get(i).getFeeling().toLowerCase() %>.png"
														class="media-photo" style="width: 63px;">
													</a>
													<div class="media-body">
														<span class="media-meta pull-right"><%=list.get(i).getDatediary() %></span>
														<a href="info.jsp?id=<%=id%>&no=<%=list.get(i).getNo()%>">
														<h4 class="title">
															<%=list.get(i).getTitle() %>
														</h4>
														</a>
														<p class="summary">
															<%=list.get(i).getContents()%>
														</p>
													</div>
												</div>
											</td>
										</tr>
									<%
										}
									%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>
	</div>
</body>
</html>
