package diemminhtri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSevrlet
 */
@WebServlet("/HelloSevrlet")
public class HelloSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloSevrlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value1 = request.getParameter("p1");
		String value2 = request.getParameter("p2");
		PrintWriter out = response.getWriter();
		out.append("Gia tri cua gia tri 1: ");
		out.append(value1);
		out.append("Gia tri cua gia tri 2: ");
		out.append(value2);
		
	}

}
