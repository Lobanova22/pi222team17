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
@WebServlet(name="result", urlPatterns="/result")
public class Result extends HttpServlet {
    
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
		RequestResult welcome = RequestResult.fromRequestParameters(request);
        welcome.setAsRequestAttributesAndCalculate(request);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
    	
	    /**
	     * The Class RequestResult.
	     */
	    private static class RequestResult {
		
		/**
		 * Instantiates a new request result.
		 */
		public RequestResult() {}

		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request result
		 */
		public static RequestResult fromRequestParameters(HttpServletRequest request) {
			return new RequestResult();
		}

		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {

		}
	}
}
