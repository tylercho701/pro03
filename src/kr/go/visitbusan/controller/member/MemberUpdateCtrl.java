package kr.go.visitbusan.controller.member;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.model.MemberDAO;

@WebServlet("/MemberUpdate.do")
public class MemberUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String id = (String) ses.getAttribute("sid");
		
		MemberDAO dao = new MemberDAO();
		Member mem = new Member();
		String msg = "";

		try {
			mem = dao.memberMyInfo(id);
		} catch (InvalidKeyException | NoSuchPaddingException
				| NoSuchAlgorithmException | InvalidKeySpecException
				| InvalidAlgorithmParameterException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		
		msg = "현재 본인 정보를 로딩하였습니다.";
		request.setAttribute("mem", mem);
		request.setAttribute("msg", msg);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberUpdate.jsp");
		view.forward(request, response);
	}
}