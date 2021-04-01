<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> guestList.jsp문서  </title>

 <style type="text/css">
   *{ font-size: 18pt; }
   a{ font-size: 18pt; text-decoration: none;  color:blue;}
   a:hover{ font-size: 20pt; text-decoration: underline; color:green;}
   #span_rcnt{font-size: 14pt; color:red; }
 </style>
 
</head>
<body>  
<!-- 컨트롤러실행 guestList.jsp문서단독실행에러발생  -->
 <table width=1200  border=1  cellspacing=0>
   <tr>
    <td colspan="7" align="right"> 데이터갯수: ${GGtotal} &nbsp; 
     <a href="guestList.jsp">[guestList]</a>
     <a href="index.jsp">[index]</a>    
    </td>
  </tr>
 
  <tr bgcolor="skyblue">
   <th>행번호</th> <th>사 번</th> <th>이 름</th>
   <th>제 목</th>  <th>날 짜 </th> <th>조회수</th> <th>메일주소</th>
  </tr>
 
 <c:forEach var="bean" items="${naver}">
  <tr>
    <td> ${bean.rn } </td>
    <td> <a href="GuestList.do?sabun=${bean.sabun}">${bean.sabun }</a> </td>
    <td> ${bean.name} </td>
    <td> ${bean.getTitle()} </td>
    <td> ${bean.wdate} </td>
    <td> ${bean.hit}  </td>
    <td> ${bean.getEmail()} </td>
  </tr>
 </c:forEach>
 
  <tr align="center">
    <td colspan="7">
    <%
     //[이전]
     //[시작페이지] ~ [endpage] 
     //다음
    %>
    </td>
  </tr>
 </table>
 
 <p>
   <a href="guestWrite.jsp">[guest입력화면]</a>
   <a href="index.html">[index화면효과]</a>
   <a href="guestList.jsp">[lotto출력]</a>
</body>
</html>
