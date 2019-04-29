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
<link rel="stylesheet" href="/Test/css/loginCss.css">
<script type="text/javascript">
	function loginCheck(){
		var obj=document.frm;
		if(!obj.id.value||!obj.password.value){
			alert('ID or Password CHECK');
			return false;
		}
		obj.submit();
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1>Login</h1>
							</div>
						</div>
						<form action="loginProcess.jsp" method="post" name="frm">
							<div class="form-group">
								<label for="exampleInputEmail1">ID</label> <input type="text"
									name="id" class="form-control" id="id"
									aria-describedby="emailHelp" placeholder="Enter ID">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Password</label> <input
									type="password" name="password" id="password"
									class="form-control" aria-describedby="emailHelp"
									placeholder="Enter Password">
							</div>
							<div class="form-group">
								<p class="text-center">
									By signing up you accept our <a href="join.jsp" id="logo"
										style="font-family: 'Kaushan Script', cursive;">Daily
										diary</a>
								</p>
							</div>
							<div class="col-md-12 text-center ">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm"
									style="margin-bottom: 30px;" onclick="loginCheck()">Login</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>