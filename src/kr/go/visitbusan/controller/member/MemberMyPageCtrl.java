package kr.go.visitbusan.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.service.MemberService;

@WebServlet("/MemberMyPage.do")
public class MemberMyPageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String id = (String) ses.getAttribute("sid");
		
		MemberService mService = new MemberService();
		Member mem = new Member();
		String msg = "";

		mem = mService.memberMyInfo(id);

		if(mem==null){
			ses.invalidate();
			msg = "현재 로그인이 되어 있지 않습니다. 로그인 하시기 바랍니다.";
			response.sendRedirect("UserLogin.do?msg="+msg);	
		} else {
			msg = "현재 본인 정보를 로딩하였습니다.";
			request.setAttribute("mem", mem);
			request.setAttribute("msg", msg);

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberMyPage.jsp");
			view.forward(request, response);
		}
	}
}