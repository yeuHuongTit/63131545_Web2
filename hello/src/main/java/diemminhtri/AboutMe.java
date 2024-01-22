package diemminhtri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutMe
 */
@WebServlet("/AboutMe")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String content = 
				  "		<div class=\"wrapper\" style=\"text-align: center; margin-top: 100px;\">\r\n"
				+ "        <h1>About me</h1>\r\n"
				+ "        <p>&#128511;</p>\r\n"
				+ "        <p> &#9924 <b>MSSV</b>: 63131545 &#127774</p>\r\n"
				+ "        <p>&#127817 <b>Họ tên</b>: Điểm Minh Trí &#129373</p>\r\n"
				+ "        <p>&#128073 <b>Lớp</b>: 63.CNTT-CLC1 &#128072</p>\r\n"
				+ "     </div>";
		out.append(content);
		
	}

}
