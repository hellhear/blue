
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
   <td colspan="5"> ��ü���ڵ尹��: ???  &nbsp; </td>
 </tr>
 
 <tr bgcolor="yellow"> 
   <th>���ȣ</th> <th>�۾���</th>  <th>�� ��</th>  <th>�� ¥</th>  <th>��ȸ��</th>  
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
   <a href="guestWrite.jsp">[guest�Է�ȭ��]</a>
   <a href="index.html">[indexȭ��ȿ��]</a>
   <a href="guestList.jsp">[lotto���]</a>
</body>

</body>
</html>