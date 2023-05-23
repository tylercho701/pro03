package kr.go.visitbusan.controller.member;

import java.io.IOException;
import java.security.InvalidKeyException;
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
import kr.go.visitbusan.model.MemberDAO;

import com.crypto.util.AES256;

@WebServlet("/MemberUpdatePro.do")
public class MemberUpdateProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Member mem = new Member();
		String key = "%03x";
		
		String id = request.getParameter("id");
		String hiddenpw = request.getParameter("hiddenpw");
		String pw = request.getParameter("pw");
		String passwd = "";
		if(pw!=hiddenpw){
			try {
				passwd = AES256.encryptAES256(pw, key);
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| InvalidKeySpecException | NoSuchPaddingException
					| InvalidParameterSpecException | BadPaddingException
					| IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mem.setId(request.getParameter("id"));
		mem.setPw(passwd);
		mem.setName(request.getParameter("name"));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		if(request.getParameter("address1")=="" || request.getParameter("address2")==""){
			mem.setAddr(request.getParameter("addr"));
		} else {
			mem.setAddr(request.getParameter("address1")+" "+request.getParameter("address2"));
		}
		
		MemberDAO dao = new MemberDAO();
		int cnt = 0;
		if(pw!=hiddenpw){
			cnt = dao.memberUpdateYesPw(mem);
		} else {
			cnt = dao.memberUpdateNoPw(mem);
		}
		
		if(cnt>=1){
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect("MemberMyPage.do?id="+id);
		}
	}
}