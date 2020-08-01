package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

import web.dispatcher.UI;

@WebServlet({ "/UserServlet", "/user" }) // dispatcher에서 /user로 이동
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Biz<String, User> biz;

	public UserServlet() {
		biz = new UserBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = request.getParameter("view");
		String cmd = request.getParameter("cmd");
		String next = "main.jsp"; // main은 고정되고 navi 영역만 바뀌게
		if (view != null) {
			UI.build(request, view);
		} // center user 만들고
		else if (cmd != null) {
			// user
			if (cmd.equals("userlist")) {
				ArrayList<User> list = null;
				try {
					list = biz.get();
					request.setAttribute("ulist", list);
					UI.build(request, cmd); //
				} catch (Exception e) {

					e.printStackTrace();
				}
			} else if (cmd.equals("useraddimpl")) {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");

				try {

					biz.register(new User(id, name, pwd));
					request.setAttribute("rid", id);
					UI.build(request, cmd);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (cmd.equals("userdeleteimpl")) {
				String id = request.getParameter("id");
				try {
					biz.remove(id);
					UI.build(request, cmd);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			else if (cmd.equals("userupdateimpl")) {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");

				User user = new User(id, pwd, name);
				try {
					biz.modify(user);
					UI.build(request, cmd); //
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		}

		RequestDispatcher rd = // main으로 넘어간다
		request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
