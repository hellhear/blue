package net.tis.guestmvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.guest.GuestDTO;
import net.tis.guest.GuestSQL;

@WebServlet("/GuestInsert.do")
public class GuestDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestDeleteController() {
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
		
		String sabun = request.getParameter("sabun");
		GuestSQL sql = new GuestSQL();
		sql.dbDelete(sabun);

		out.println("<script type=\"text/javascript\"> ");
		out.println("alert('�����Ϸ�');");
		out.println("</script>");
		
		RequestDispatcher dis = request.getRequestDispatcher("guestWrite.jsp");
    dis.forward(request, response);
	}


}
