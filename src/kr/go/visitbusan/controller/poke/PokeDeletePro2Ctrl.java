package kr.go.visitbusan.controller.poke;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.go.visitbusan.dto.Poke;
import kr.go.visitbusan.service.PokeService;

@WebServlet("/PokeDeletePro2.do")
public class PokeDeletePro2Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject json = new JSONObject();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pokeId = request.getParameter("pokeId");
		String sid = request.getParameter("sid");

		PokeService service = new PokeService();
		
		int i = service.DeletePoke(pokeId);
		
		if (i > 0){
			response.sendRedirect(request.getContextPath()+"/PokeListbyMemberId.do?sid="+sid);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}
}