<%@page import="org.omg.CORBA.FieldNameHelper"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileUpload"%>
<%@page import="sist.com.model.DiaryBeanInput"%>
<%@page import="sist.com.dao.DiaryDao"%>
<%@page import="sist.com.model.DiaryBean"%>
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
	request.setCharacterEncoding("EUC-KR");
	int no=Integer.parseInt(request.getParameter("no"));
	 String job=request.getParameter("job")==null?"":request.getParameter("job");
	String id=request.getParameter("id");
	/*	String date=request.getParameter("date");
	String title=request.getParameter("title");
	String contents=request.getParameter("contents");
	String feeling=request.getParameter("feeling").trim();
	String weather=request.getParameter("weather").trim();
	
	String file=request.getParameter("file").trim();

	DiaryBean bean=new DiaryBean();
 	bean.setDatediary(date);
	bean.setTitle(title);
	bean.setContents(contents);
	bean.setFeeling(feeling);
	bean.setWeather(weather);
	bean.setMemberno(no);
	bean.setFileName(file); 
   String file=request.getParameter("file").trim();
	out.print(bean.getTitle()+"  "+bean.getWeather());*/
					
	DiaryBean bean=new DiaryBean();	
	
	String path="E:\\jsp\\Test\\WebContent\\projectBoard\\Upload\\";
	String fileName="";
	
	//파일업로드
	if(FileUpload.isMultipartContent(request)){//웹브라우저가 multipart.form-data 인코딩 타입으로 데이터를 전송했는지 확인
											   //multipart.form-data 타입 인코딩일 경우,
		DiskFileUpload fileUpload=new DiskFileUpload();//업로드 객체 생성
		fileUpload.setRepositoryPath(path);//임시 업로드 경로
		fileUpload.setSizeMax(1024*1024*3);
		
		List<FileItem> fileItemList=fileUpload.parseRequest(request);
				
		for(int i=0;i<fileItemList.size();i++){
			FileItem fileItem=(FileItem)fileItemList.get(i);
			
			String fieldName=fileItem.getFieldName();
			
			if(fieldName.equals("date")){
				bean.setDatediary(fileItem.getString("EUC-KR"));
			}
			if(fieldName.equals("title")){
				bean.setTitle(fileItem.getString("EUC-KR"));
			}
			if(fieldName.equals("contents")){
				bean.setContents(fileItem.getString("EUC-KR"));
			}
			if(fieldName.equals("feeling")){
				bean.setFeeling(fileItem.getString("EUC-KR"));
			}
			if(fieldName.equals("weather")){
				bean.setWeather(fileItem.getString("EUC-KR"));
			}
			if(!fileItem.isFormField()){
				if(fileItem.getName()!=null&&fileItem.getName().length()>0){
					fileName=fileItem.getName();
					File file2=new File(path+fileItem.getName());
					
					try{
						fileItem.write(file2);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		} 
	}
	
	bean.setFileName(fileName);
	bean.setMemberno(no);
	
	if(job.equals("modify")){
		DiaryDao.updateData(bean);
	}else{
		DiaryDao.insertData(bean);
		
	} 
	
	System.out.println(bean.toString());
	
	response.sendRedirect("list.jsp?id=saehe12"); 
	
%>
</body>
</html>