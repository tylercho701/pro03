package kr.go.visitbusan.controller.visit;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.go.visitbusan.dto.Visit;
import kr.go.visitbusan.service.VisitService;

@WebServlet("/VisitInsertPro.do")
public class VisitInsertProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/visit/img";
		int uploadFileSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		String main = "", sub1="", sub2="";
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath,
				uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		main = multi.getFilesystemName("imgMain");
		sub1 = multi.getFilesystemName("imgSub1");
		sub2 = multi.getFilesystemName("imgSub2");
		
		Visit visit = new Visit();
		visit.setVisitTitle(multi.getParameter("title"));
		visit.setVisitCateCode(multi.getParameter("cateCode"));
		visit.setVisitAddr(multi.getParameter("address1")+" "+multi.getParameter("address2")+" ("+multi.getParameter("postcode")+")");
		visit.setVisitMapLink(multi.getParameter("mapLink"));
		if(main!=null){
			visit.setVisitImgMain("."+savePath.substring(6, savePath.length())+"/main/"+main);
		}
		if(sub1!=null){
			visit.setVisitImgSub1("."+savePath.substring(6, savePath.length())+"/sub1/"+sub1);
		}
		if(sub2!=null){
			visit.setVisitImgSub2("."+savePath.substring(6, savePath.length())+"/sub2/"+sub2);
		}
		visit.setVisitText(multi.getParameter("visitText"));
		
		VisitService service = new VisitService();
		int i = service.insertVisit(visit);
		if (i>0){
			response.sendRedirect(request.getContextPath()+"/VisitCtrl.do");
		} else {
			response.sendRedirect("");
		}
	}
}