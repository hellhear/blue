
<%@page import="net.tis.guest.GuestDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>



<body>
   GuestList.jsp <p> 
   
<%
	ArrayList<GuestDTO> guestArr = (ArrayList)request.getAttribute("guestArr");
%>   
   
<table width=900 border=1 cellspacing=0>
 <tr align="right">
   <td colspan="5"> 전체레코드갯수: ???  &nbsp; </td>
 </tr>
 
 <tr bgcolor="yellow"> 
   <th>행번호</th> <th>글쓴이</th>  <th>제 목</th>  <th>날 짜</th>  <th>조회수</th>  
 </tr>
 
 <%
  for(GuestDTO gdto : guestArr){ 
 %> 	
  <tr>
     <td> <%= gdto.getSabun() %> </td>
     <td> <%= gdto.getName()%> </td>
     <td> <%= gdto.getTitle()%> </td>
     <td> <%= gdto.getPay()%> </td>
     <td> <%= gdto.getEmail()%> </td>
  </tr>
<% } %>

</table>
   <p>
   <a href="guestWrite.jsp">[guest입력화면]</a>
   <a href="index.html">[index화면효과]</a>
   <a href="guestList.jsp">[lotto출력]</a>
</body>

</body>
</html>