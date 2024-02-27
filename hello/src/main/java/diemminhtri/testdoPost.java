package diemminhtri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testdoPost
 */
@WebServlet("/testdoPost")
public class testdoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testdoPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setContentType("text/html; charset=utf-8");
		//response.setCharacterEncoding("utf--8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter traVe = response.getWriter();
		traVe.append("Bạn vửa gửi request dạng GET, đây là response cuẩ tôi: ");
		
		String noiDung = "<form method = POST action=\"/hello/testdoPost\">"
				+ "        <label>Họ: </label>\n"
				+ "        <input type=\"text\" name=\"fname\">\n"
				+ "        <br>\n"
				+ "        <label>Tên: </label>\r\n"
				+ "        <input type=\"text\" name=\"lname\">\n"
				+ "        <br>\n"
				+ "        <input type=\"submit\" value=\"Gửi\">\n"
				+ "    </form>";
		traVe.append(noiDung);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setContentType("text/html; charset=utf-8");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		PrintWriter traVe = response.getWriter();
		traVe.append("Ban vua gui request dang POST");
		traVe.append("Ho: ");
		traVe.append(fname);
		traVe.append("Ten: ");
		traVe.append(lname);
	}

}
