package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dispatcher.UI;

@WebServlet({ "/ProductServlet", "/product" }) // dispatcher에서 /product로 이동
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view=request.getParameter("view");
		String next="main.jsp";  // main은 고정되고 navi 영역만 바뀌게
		if(view!=null) {
			UI.build(request, view);
		}								//center user 만들고
		
			RequestDispatcher rd = 			//main으로 넘어간다
			request.getRequestDispatcher(next);   
			rd.forward(request, response);
	}

}
