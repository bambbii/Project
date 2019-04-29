<%@page import="sist.com.model.DiaryMember"%>
<%@page import="sist.com.dao.DiaryDao"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String pw=request.getParameter("password");
	String gender=request.getParameter("gender");
 	DiaryMember bean=new DiaryMember();
	bean.setName(name);
	bean.setId(id);
	bean.setPassword(pw);
	bean.setGender(gender);
	DiaryDao.joinMember(bean);
	response.sendRedirect("login.jsp");
%>
</body>
</html>