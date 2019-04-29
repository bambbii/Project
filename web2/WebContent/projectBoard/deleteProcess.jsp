<%@page import="java.util.HashMap"%>
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
	int no=Integer.parseInt(request.getParameter("no"));//글번호
	String id=request.getParameter("id");
	
	DiaryDao.deleteDiaryInfo(no);
	
	response.sendRedirect("list.jsp?id="+id);
%>
</body>
</html>