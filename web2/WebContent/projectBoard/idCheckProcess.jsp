<%@page import="sist.com.dao.DiaryDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String dbId=DiaryDao.idCheck(id);
	String state="";
	if(dbId!=null&&id.equals(dbId)){
		state="no";
		request.setAttribute("state", state);
		RequestDispatcher rd=request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}else{
		state="yes";
		request.setAttribute("state",state);
		RequestDispatcher rd=request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>