package kr.go.visitbusan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Category;
import kr.go.visitbusan.service.CateService;


@WebServlet("/MenuLoad.do")
public class MenuLoadCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		bJson(request, response);
	}
	
	public void bJson(HttpServletRequest request, HttpServletResponse response) throws IOException{
		CateService cService = new CateService();
		ArrayList<Category> cateList = cService.menuLoad();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cateList", cateList);
		
		net.sf.json.JSONObject json = new net.sf.json.JSONObject();
		json.putAll(map);
		
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}
}