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
	String id=request.getParameter("id");
	String pw=request.getParameter("password");
	DiaryMember bean=DiaryDao.passCheck(id)==null?new DiaryMember(0,null,null,null,null):(DiaryMember)DiaryDao.passCheck(id);
	if(bean.getPassword()!=null&&pw.equals(bean.getPassword())){
		pageContext.getSession().setAttribute("id",id);
		session.setMaxInactiveInterval(60*2);
		response.sendRedirect("list.jsp?id="+id);
		out.print("true");
	}else{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>