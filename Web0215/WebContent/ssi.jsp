<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" %>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%!
 Connection CN; //db서버연결정보, 명령어생성할때 참조
 Statement ST; //명령어생성 ST = CN.createStatement()
 PreparedStatement PST; //속도가빠름 PST = CN.prepareStatement("insert~/update~")
 CallableStatement CST ; //데이터베이스의 함수프로시저 사용 
 ResultSet RS; //select조회한결과 RS=ST.executeQuery("select~~")
 
 String  Gtitle, Gcontent, Gwriter ;
 java.util.Date  Gwdate;
 int Ghit ;
 
 int GGtotal, Gtotal ;
 String msg ;  //msg="dml쿼리문기술 insert~/select~/update~/delete~"
 String data ;  //data=request.getParameter("idx");

 String gm;	//관리자 여부
 int no; //고유 숫자
 //test테이블에서 사용
 int Gpay , Gcode;
 String Ggender, Gimage;
 
%>	

<% 
 try{
   //순서1 db데이터베이스 드라이브연결
   Class.forName("oracle.jdbc.driver.OracleDriver");
   //System.out.println("Web0215플젝 오라클드라이브 연결성공 111 월요일 2:24분 ");
   
   //순서2 db데이터베이스 서버정보주소및포트 계정id/pwd
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN=DriverManager.getConnection(url ,"system","1234");
   //System.out.println("Web0215플젝 오라클서버정보및 id,pwd 연결성공 222 월요일 2:24분  ");
   
   ST=CN.createStatement(); //권장
 }catch(Exception ex){ System.out.println("db 에러 " + ex.toString());}
%>
</body>
</html>