package web.dispatcher;

import javax.servlet.http.HttpServletRequest;

public class UI {
	// make ui
		
		public static void build(HttpServletRequest request,
				String view){
			if(view.equals("login")) {
				request.setAttribute("navi", Navi.login);  // navi 창
				request.setAttribute("center", "login");   // main 창
			}else if(view.equals("register")) {
				request.setAttribute("navi", Navi.register);
				request.setAttribute("center", "register");
			}
			else if(view.equals("aboutus")) {
			request.setAttribute("navi", Navi.aboutus);
			request.setAttribute("center", "aboutus");
			}
			
			
			//user
			else if(view.equals("useradd")) {
				request.setAttribute("navi", Navi.useradd);
				request.setAttribute("center", "user/add");   //user폴더의 add.jsp
			}
		
			else if(view.equals("userlist")) {
				request.setAttribute("navi", Navi.userlist);
				request.setAttribute("center", "user/list");   
			}
			else if(view.equals("userdelete")) {
				request.setAttribute("navi", Navi.userdelete);
				request.setAttribute("center", "user/delete");   
			}
			else if(view.equals("userupdate")) {
				request.setAttribute("navi", Navi.userupdate);
				request.setAttribute("center", "user/update");   
			}
			
			//product
			
			else if(view.equals("prodcutadd")) {
				request.setAttribute("navi", Navi.productadd);
				request.setAttribute("center", "product/add");   
			}
			
		}
}
