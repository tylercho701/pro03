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

@WebServlet("/PokeDeletePro.do")
public class PokeDeleteProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject json = new JSONObject();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		pokeDelete(request, response);
	}
	
	public void pokeDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pokedBy = request.getParameter("pokedBy");
		String visitId = request.getParameter("visitId");
		Poke poke = new Poke();
		poke.setPokedBy(pokedBy);
		poke.setVisitId(visitId);
		
		PokeService service = new PokeService();
		Poke nPoke = service.CheckPoke(poke);
		
		int i = service.DeletePoke(nPoke.getPokeId());
		
		if (i > 0){
			json.put("res", "1");
			PrintWriter out = response.getWriter();
			out.println(json.toString());
		} else {
			json.put("res", "0");
			PrintWriter out = response.getWriter();
			out.println(json.toString());
		}
	}
}