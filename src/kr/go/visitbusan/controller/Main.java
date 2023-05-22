package kr.go.visitbusan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Main() { super(); }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String msg = "VisitBusan";
		
		// 홈 디렉토리
		ServletContext application = request.getServletContext();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		application.setAttribute("realPath", realPath);
		
		// 메인 페이지 포워딩
		request.setAttribute("msg", msg);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		view.forward(request, response);
	}

}
