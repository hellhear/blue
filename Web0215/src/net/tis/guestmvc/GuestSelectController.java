package net.tis.guestmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.guest.GuestDTO;
import net.tis.guest.GuestSQL;

@WebServlet("/GuestList.do")
public class GuestSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestSelectController() {
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
		response.setContentType("text/html; charset=UTF-8"); // 78페이지 한글지원
		PrintWriter out = response.getWriter();
		out.println("<h1>GuestSelectController.java</h1>");
		
		String bun =request.getParameter("sabun");
		System.out.println(bun);
		if(!(bun==null || bun=="")) {
	    GuestSQL gs = new GuestSQL();
	    int GGtotal = gs.getTotal() ;
	    GuestDTO naver = gs.dbSelectAll(bun); //jsp교재 59페이지참고
	    request.setAttribute("naver", naver);
	    request.setAttribute("GGtotal", GGtotal);
	    

	    RequestDispatcher dis = request.getRequestDispatcher("guestDetail.jsp");
	    dis.forward(request, response);
		}
		
		
	    GuestSQL gs = new GuestSQL();
	    int GGtotal = gs.getTotal() ;
	    ArrayList naver = gs.dbSelectAll(); //jsp교재 59페이지참고
	    request.setAttribute("naver", naver);
	    request.setAttribute("GGtotal", GGtotal);


	    RequestDispatcher dis = request.getRequestDispatcher("guestList2.jsp");
	    dis.forward(request, response);
		
		
//		ArrayList<GuestDTO> arr = new ArrayList<GuestDTO>();
//		GuestSQL gsql = new GuestSQL();		
//		arr = gsql.dbSelectAll();		
//		request.setAttribute("guestArr", arr);
//		RequestDispatcher dis=request.getRequestDispatcher("guestList2.jsp");
//		dis.forward(request, response);
		
		

	}


}
