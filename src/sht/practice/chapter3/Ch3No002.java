package sht.practice.chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ch3No002")
public class Ch3No002 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String store = request.getParameter("store");
		String selectedStore;

		if(store  == null) {
			selectedStore = "選択されていません";
		}else {
			switch(store) {
			case "seven":
				selectedStore = "セブンイレブン";
				break;
			case "lawson":
				selectedStore = "ローソン";
				break;
			case "family":
				selectedStore = "ファミリーマート";
				break;
			default:
				selectedStore = "???";
				break;
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Ch3No002</title></head><body>");
		out.println(selectedStore);
		out.println("</body></html>");
	}
}
