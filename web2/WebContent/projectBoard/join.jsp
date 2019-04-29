<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet" href="/Test/css/joinCss2.css">
<link rel="stylesheet" href="/Test/css/joinCss.css">
<script type="text/javascript">
	function pwCheck(){
		var pw1=document.getElementById("password1").value;
		var pw2=document.getElementById("password2").value;
		var pwCheck=document.getElementById("pwCheckMsg");
		if(pw1!=pw2){
			pwCheck.style.display="block";
		}
		if(pw1==pw2){
			document.getElementById("password").value=pw2;
		}
		
	}
	function pwFocus(){
		var pw1=document.getElementById("password1").value;
		var pw2=document.getElementById("password2").value;
		var pwCheck=document.getElementById("pwCheckMsg");
		pwCheck.style.display="none";
	}
	
	function checkId(){
		var obj=document.getElementById('id').value;
		var name=document.getElementById('name').value;
		document.location.href="idCheckProcess.jsp?id="+obj+"&name="+name;
	}
</script>
<%
	String name=request.getParameter("name")==null?"":request.getParameter("name");
	
	String id=request.getParameter("id")==null?"":request.getParameter("id");
	String state=request.getAttribute("state")==null?"":(String)request.getAttribute("state");
	String idCheck="";
	if(id!=null&&state.equals("no")){
		idCheck="사용 중인 아이디 입니다.";
	}else if(state.equals("yes")){
		idCheck="사용 가능한 아이디 입니다.";
	}
%>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1>Join</h1>
							</div>
						</div>
						<form action="joinProcess.jsp" method="post" id="frm">
							<div class="form-group">
								<label>Full Name:</label> <input class="form-control"
									type="text" name="name" id="name" required
									placeholder="Enter Your Full Name"
									value=<%=name!=null?name:""%>> <span class="Error"></span>
							</div>
							<div class="form-group">
								<label>ID:</label> <span id="sp"
									style="color: red; font-size: 14px;"><%=idCheck %></span> <input
									class="form-control" type="text" name="id" id="id" required
									placeholder="Enter Your Email" onblur="checkId()"
									value=<%=id!=null?id:"" %>> <span class="Error"></span>
							</div>
							<div class="form-group">
								<label>Password:</label> <input class="form-control"
									type="password" name="password1" id="password1" required
									placeholder="Enter Password" onfocus="pwFocus()" /> <span
									class="Error"></span>
							</div>
							<div class="form-group">
								<label>Password Check:</label> <input class="form-control"
									type="password" name="password2" id="password2" required
									placeholder="Enter Password" onfocus="pwFocus()"
									onblur="pwCheck()" /> <span class="Error"></span>
							</div>
							<p id="pwCheckMsg"
								style="color: red; font-size: 12px; margin: 0; display: none">비밀번호가
								다릅니다. 다시 확인 해 주세요</p>
							<input type="hidden" name="password" id="password">

							<div class="form-group">
								<label>Gender:</label><br /> <label><input type="radio"
									name="gender" required value="Male" checked /> Male</label> <label><input
									type="radio" name="gender" required value="Female" /> Female</label> <span
									class="Error"></span>
							</div>
							<div class="form-group">
								<input class="btn btn-primary btn-block" type="submit"
									value="Submit" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>