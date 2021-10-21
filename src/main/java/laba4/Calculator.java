package laba4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //���������� �������� � URL
public class Calculator extends HttpServlet  {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calculator = RequestCalc.fromRequestParameters(request);
		Calculator.setAsRequestAttributeAndCalculate(request);
		
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
		private double perimetr;
		
		private RequestCalc (String first, String second) {
			this.first_calc = first;
			this.second_calc = second;
		}
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first"),
			request.getParameter("second"));
		}
		public void setAsRequestAttributeAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", first_calc);
			request.setAttribute("second_result", second_calc);
			
			double first_try;
			double second_try;
			
			try {
				
			first_try=Double.parseDouble(first_calc);
			second_try=Double.parseDouble(second_calc);
			}
			catch (NumberFormatException e)  {	
				first_try=0;
				second_try=0;
		
			}
			
		perimetr=2 * (first_try + second_try);
		request.setAttribute("perimetr", perimetr);
		}
		}	
}
