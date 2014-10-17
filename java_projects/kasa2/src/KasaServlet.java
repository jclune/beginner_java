import java.io.*;

import javax.servlet.*; 
import javax.servlet.http.*;
//import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class KasaServlet
 */
//@WebServlet("/KasaServlet")
public class KasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KasaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String rain = request.getParameter("rain");
		PrintWriter out = response.getWriter();
		String output = null;
		if (rain != null) {
			 	int n = Integer.parseInt(rain);
			if (n < 0 || 100 < n){
				output = "Please choose a probability between 0 and 100%";
			} else if ( n > 50){
				output = "Chance is "+n+"%. Looks like it will rain. take a Kasa!";
			} else {
				output = "Chance is "+n+"%. Eh I'm willing to chance it.";
			}
		}
		// 出力
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>please say the chance of rain</p><form action=\"kasa\" method=\"get\">Chance (0-100%)：<input type=\"text\" name=\"rain\" /><input type=\"submit\" value=\"送信\" /><br />");
		if (output != null) {
			out.println(output);
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
