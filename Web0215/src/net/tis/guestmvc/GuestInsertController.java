package net.tis.guestmvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.guest.GuestDTO;
import net.tis.guest.GuestSQL;

@WebServlet("/GuestInsert.do")
public class GuestInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doUser(request, response);
	}
	
	protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8"); // 78������ �ѱ�����
		PrintWriter out = response.getWriter();
		out.println("<h1>GuestInsertController.java</h1>");
		
		String name, email, title;
		int pay,sabun;
		name = request.getParameter("name");
		pay = Integer.parseInt(request.getParameter("pay"));
		title = request.getParameter("title");
		email = request.getParameter("email");
		sabun = Integer.parseInt(request.getParameter("sabun"));

		GuestDTO gdto = new GuestDTO();
		
		gdto.setName(name);
		gdto.setPay(pay);
		gdto.setEmail(email);
		gdto.setSabun(sabun);
		gdto.setTitle(title);
		
		GuestSQL gsql = new GuestSQL();
		
		gsql.dbInsert(gdto);
		
		out.println("�Ѱܹ��� ��� : " + sabun+"<br>");
		out.println("�Ѱܹ��� �̸� : " + name+"<br>");
		out.println("�Ѱܹ��� ���� : " + title+"<br>");
		out.println("�Ѱܹ��� �޿� : " + pay+"<br>");
		out.println("�Ѱܹ��� ���� : " + email+"<br>");
		
		out.println("<h2>������ �Ϸ�Ǿ� ���ϴ�.</h2><br><br>");
		
		out.println("<IMG src = images/a1.png>");
		
	}


}
