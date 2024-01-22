package diemminhtri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMI
 */
@WebServlet("/BMI")
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI() {
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
		PrintWriter out = response.getWriter();
		
		String content = "<form method = POST action=\"/hello/BMI\">"
				+ "        <label>Nhập chiều cao(m): </label>\n"
				+ "        <input type=\"text\" name=\"height\">\n"
				+ "        <br>\n"
				+ "        <label>Nhập cân nặng(kg): </label>\r\n"
				+ "        <input type=\"text\" name=\"weight\">\n"
				+ "        <br>\n"
				+ "        <input type=\"submit\" value=\"Gửi\">\n"
				+ "    </form>";
		out.append(content);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");

        float height = Float.parseFloat(heightStr);
        float weight = Float.parseFloat(weightStr);
		
        float bmi = weight/(height*height);
        if (bmi < 18.5) {
        	out.append("Bạn bị thiếu cân(" +  bmi + ")");
        } else if (bmi < 25) {
        	out.append("Bạn khỏe mạnh(" +  bmi + ")");
        } else if (bmi < 30) {
        	out.append("Bạn bị thừa cân(" +  bmi + ")");
        } else {
        	out.append("Bạn bị béo phì(" +  bmi + ")");
        }
		
	}

}
