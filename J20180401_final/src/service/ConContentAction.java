package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConDAO;
import dao.ConDTO;

public class ConContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			ConDAO cdao = ConDAO.getInstance();
			String memNo = request.getParameter("memNo");
			String consultNo = request.getParameter("consultNo");
			String startNum = request.getParameter("startNum");
			cdao.readcount(consultNo,memNo);
			ConDTO cdto = cdao.content(memNo, consultNo);
			request.setAttribute("memNo", memNo);
			request.setAttribute("consultNo", consultNo);
			request.setAttribute("startNum", startNum);
			request.setAttribute("cdto", cdto);
			System.out.println("cdto = " +cdto);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "conContentForm.jsp";
	}

}
