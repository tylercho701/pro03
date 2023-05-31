package kr.go.visitbusan.controller.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import kr.go.visitbusan.dto.Category;
import kr.go.visitbusan.service.CateService;



@WebServlet("/CateListbyCateGroup.do")
public class CateListbyCateGroupCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		String cateGroup = request.getParameter("catGroup");
		CateService cService = new CateService();
		
		if (cateGroup != null){
			ArrayList<Category> cateList = cService.CateListByCateGroup(cateGroup);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("result", cateList);
			
			JSONObject json = new JSONObject();
			json.putAll(map);
			PrintWriter out = response.getWriter();
			out.println(json.toString());
		}
	}
}