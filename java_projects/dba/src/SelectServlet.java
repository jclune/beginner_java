import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import UserDao.*;


public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectServlet() {
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String formTest = null;
		formTest = request.getParameter("form_test");
		request.setAttribute("form_test", formTest);
		session.setAttribute("test", "session test works");	
		request.setAttribute("test", "test works");	
		
		Dao dao = new Dao();
		//login
		String loginName = null;
		String loginPasswd = null;
		session.setAttribute("user",null);
		try {
			loginName = request.getParameter("loginName");
			loginPasswd = request.getParameter("loginPasswd");			
		}catch(NumberFormatException e){
			System.out.println("Error. number format exception");
		}
		if (loginName == null || loginName == "" || loginPasswd == null || loginPasswd == null){
			System.out.println("Login info is null or empty");
		}else{
			User thisUser = dao.login(loginName, loginPasswd);
			if (thisUser == null){
				System.out.println("Wrong username or password");
			} else {
				System.out.println("logged in as user: "+thisUser.getName());
				session.setAttribute("user",thisUser);
			}
		}
		
		//create account
		String formName = null;
		String formTel = null;
		String formPasswd = null;
		try {
			formName = request.getParameter("name");
			formTel = request.getParameter("tel");
			formPasswd = request.getParameter("passwd");
		}catch(NumberFormatException e){
			System.out.println("Error. number format exception");
		}
		
		if (formName == null || formName == "" || formTel == null || formTel == ""|| formPasswd == null || formPasswd == ""){
			System.out.println("New account info is null or empty");
		}else{
			User newUser = new User();
			newUser.setName(formName);
			newUser.setTel(formTel);
			newUser.setPasswd(formPasswd);
			dao.insert(newUser);
			session.setAttribute("user",newUser);
		}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
