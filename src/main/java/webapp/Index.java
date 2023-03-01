package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Auto-generated Javadoc

/**
 * The Class Welcome.
 * @author Diana
 */
@WebServlet(name="index", urlPatterns="/index")
public class Index extends HttpServlet {
    
    /**
     * Do post.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		RequestIndex welcome = RequestIndex.fromRequestParameters(request);
        welcome.setAsRequestAttributesAndCalculate(request);

		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
    	
	    /**
	     * The Class RequestIndex.
	     */
	    private static class RequestIndex {
			/** The calculation. */
			private Calculation calculation;

		/**
		 * Instantiates a new request index.
		 */
		public RequestIndex(String surname, String name, String patronymic, String period, String power, String privileges, String luxury) {
			calculation = new Calculation(surname, name, patronymic, Integer.parseInt(period), Integer.parseInt(power), privileges, luxury);
		}

		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request index
		 */
		public static RequestIndex fromRequestParameters(HttpServletRequest request) {
			return new RequestIndex(
					request.getParameter("surname"),
					request.getParameter("name"),
					request.getParameter("patronymic"),
					request.getParameter("period"),
					request.getParameter("power"),
					request.getParameter("privileges"),
					request.getParameter("luxury")
			);
		}

		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			String surname = calculation.getSurname();
			String name = calculation.getName();
			String patronymic = calculation.getPatronymic();
			int period = calculation.getPeriod();
			int power = calculation.getPower();
			String privileges = calculation.getPrivileges();
			String luxury = calculation.getLuxury();
			double result = calculation.Calculate();

			request.setAttribute("surname", surname);
			request.setAttribute("name", name);
			request.setAttribute("patronymic", patronymic);
			request.setAttribute("period", period);
			request.setAttribute("power", power);
			request.setAttribute("privileges", privileges);
			request.setAttribute("luxury", luxury);
			request.setAttribute("result", result);

			GeneratePDF(calculation, result);
		}

		public void GeneratePDF(Calculation calculation, double result) {
			CreatePDF PDF = new CreatePDF();
			try {
				PDF.Create(calculation, result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
