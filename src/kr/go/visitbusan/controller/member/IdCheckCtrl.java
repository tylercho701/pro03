package kr.go.visitbusan.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.model.MemberDAO;

import org.json.JSONObject;

@WebServlet("/IdCheck.do")
public class IdCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.idCheck(id);
		boolean result = false;
		if(cnt>=1){
			result = false;
		} else {
			result = true;
		}
		JSONObject json = new JSONObject();
		json.put("result", result);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
}