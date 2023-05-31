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

@WebServlet("/PokeCheck.do")
public class PokeCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject json = new JSONObject();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		pokeCheck(request, response);
	}
	
	public void pokeCheck(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pokedBy = request.getParameter("pokedBy");
		String visitId = request.getParameter("visitId");
		Poke poke = new Poke();
		poke.setPokedBy(pokedBy);
		poke.setVisitId(visitId);
		
		PokeService service = new PokeService();
		Poke nPoke = service.CheckPoke(poke);
		
		if (nPoke.getPokeId() != null){
			json.put("res", "1");
			PrintWriter out = response.getWriter();
			out.println(json.toString());
		} else {
			request.setAttribute("pokeId", nPoke.getPokeId());
			json.put("res", "0");
			PrintWriter out = response.getWriter();
			out.println(json.toString());
		}
	}
}