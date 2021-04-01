<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="ssi.jsp" %>

<html>
<head><title> [loginSave.jsp] </title></head>
<body>		
<%
  //String usera=request.getParameter("userid");
  //String userb=request.getParameter("pwd");
  String usera=request.getParameter("UID");
  String userb=request.getParameter("UPWD");
  session.removeAttribute("");

  System.out.println(usera + "  " + userb);
  msg="select count(*) as cnt from bbs where b_id=? and b_pwd=? ";
  PST=CN.prepareStatement(msg);
  	PST.setString(1, usera);	//login.jsp에서 아이디 가져온거.
  	PST.setString(2, userb);	//login.jsp에서 비번을 가져온거.
  RS=PST.executeQuery(); 			//커리문 실행.
  RS.next(); Gtotal=RS.getInt("cnt");
	//커리문 다음 문으로.	//커리문 결과 cnt가 0이 아니면 일치하는것이 존재
  if(Gtotal>0){//일치 했을 경우
  	System.out.println(usera + "  " + gm);
  	 msg="select b_gm, b_no, b_nickname from bbs where b_id=?";
  	 PST=CN.prepareStatement(msg);
  	 PST.setString(1,usera);
  	 RS=PST.executeQuery();
  	 RS.next();
  	 
  	 session.setAttribute("b_id", usera); //아이디
   	 session.setAttribute("b_gm", RS.getString("b_gm")); //관리자 권한 0,1
  	 session.setAttribute("b_no", RS.getString("b_no"));
  	 session.setAttribute("b_nick", RS.getString("b_nickname"));
  	 System.out.println("login처리 성공 세션값 설정 성공");
  	 response.sendRedirect("index.html");
  	 
  	 //Cookie ck=new Cookie("daum", usera); //웹서버에서 제공되는 쿠키내장클래스 객체화 
  	 //response.addCookie(ck); //쿠키추가등록
  	 //response.sendRedirect("index.jsp");
  	
  %>
   <font size=7 color=blue>
     <b><%= usera %>님 로그인 성공!!!</b> <br>
   </font><p>
	<img src="images/bt_login.gif" width=450 height=70><p>
	<img src="images/bar.gif" width=450 >
 <%  
  }else{
  	System.out.println("실패!");
  	 out.println("<font size=7 color=red><b></b>"+usera+"님 로그인실패</font><br>");
     out.println("<font size=7><a href='login.jsp'>[로그인]</a></font>");
     out.println("<font size=7><a href='index.jsp'>[index]</a></font><br>"); 
 %> 	
  	<img src="../images/gallery1.jpg" width=450 ><p>
  	 <script type="text/javascript">
        setTimeout("location.href='login.jsp'", 3000); //3초후에 login.jsp
    </script>
<% } %>
	
	
</body>
</html>





