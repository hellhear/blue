<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  </title>
 <style type="text/css">
   *{ font-weight: bold;}
 </style>
 
 <script type="text/javascript">
 </script>
 
</head>
<body>
 <%
 
 %> 
 
  <table border="1" width="900"  cellspacing="0" cellpadding="10px">
   <tr align="center">
   	 <td colspan="5">
   	 	<font style="font-size:24pt;color:orange">님의 상세페이지 환영합니다 </font> 
   	  </td>
   </tr>
  	<tr>
  		<td width="400"  rowspan="5" align="center">
  		  <img src="images/bbb.gif" width="350" height="200"> 
  		</td> 
  		<td> 사번:   ${naver.sabun } </td>
  	</tr> 	
  	<tr>
  	   <td> 메일:  ${naver.email } </td>
  	</tr>
  	<tr>
  	   <td> 날짜:  ${naver.wdate }  </td>
  	</tr>
   	<tr>  
  	   <td> 급여:  ${naver.pay }  </td>
  	</tr>
  	<tr>
  	   <td> 
  			<a href="testList.jsp">[testList]</a>
  			<a href="guestList.jsp">[guestList]</a>
  			<a href="guestDelete.do?sabun=${naver.sabun}">[삭제]</a>
  			<a href="index.jsp">[index]</a>
  			<a href="#">[guest수정]</a>
  	   </td>
  	</tr>
 </table>

	
</body>
</html>
















