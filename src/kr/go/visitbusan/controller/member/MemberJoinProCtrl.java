package kr.go.visitbusan.controller.member;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.service.MemberService;
import kr.go.visitbusan.util.AES256;

@WebServlet("/MemberJoinPro.do")
public class MemberJoinProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Member mem = new Member();
		String key = "%03x";
		
		String pw = request.getParameter("pw");
		String passwd = "";
		
		try {
			passwd = AES256.encryptAES256(pw, key);
		} catch (java.security.InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		
		mem.setId(request.getParameter("id"));
		mem.setPw(passwd);
		mem.setName(request.getParameter("name"));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		mem.setAddr(request.getParameter("address1")+" "+request.getParameter("address2"));
		
		MemberService mService = new MemberService();
		int cnt = mService.memberInsert(mem);
		if(cnt>=1){
			response.sendRedirect("MemberLogin.do");
		} else {
			response.sendRedirect("MemberJoin.do");
		}
	}
}