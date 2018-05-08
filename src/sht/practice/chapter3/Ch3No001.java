package sht.practice.chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ch3No001")
public class Ch3No001 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] values = request.getParameterValues("food");
		String selectedFood = "-";
		if(values == null) {
			selectedFood = "選択されていません";
		}else {
			for(String food:values) {
				switch(food) {
				case "apple":
					selectedFood += "りんご" + "-";
					break;
				case "orange":
					selectedFood += "みかん" + "-";
					break;
				case "strawberry":
					selectedFood += "いちご" + "-";
					break;
				default:
					selectedFood += "???" + "-";
					break;
				}
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>no001</title></head><body>");
		out.println(selectedFood);
		out.println("</body></html>");
	}
}
