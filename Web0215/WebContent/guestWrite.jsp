<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> guestWrite.jsp </title>

 <style type="text/css">
   *{ font-size: 16pt;  }
   a{ font-size: 16pt; text-decoration: none; }
   a:hover{ font-size: 20pt; text-decoration: underline; }
 </style>
 
 <script type="text/javascript"> 
  
 </script>
 
</head>
<body>
  <h2> guestWrite.jsp </h2>
   <form name="myform"  action="GuestInsert.do"  >
      사번:  <input type="text" name="sabun" >  <br>
      이름:  <input type="text" name="name" >  <br>
      제목:  <input type="text" name="title" value="color">  <br>
      급여:  <input type="text" name="pay" value="71">  <br>
      메일:  <input type="text" name="email" value="st@daum">  <br>
         <input type="submit" value="mvc2게스트저장" > &nbsp;
         <input type="reset" value="취소">  
  </form>
  
  <p>
  <a href="guestWrite.jsp">[guestWrite]</a>
  <a href="GuestList.do">[guestList]</a>
  <a href="index.jsp">[index]</a>
  <a href="#">[로그인]</a>
</body>
</html>







