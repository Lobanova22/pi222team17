package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

// TODO: Auto-generated Javadoc

/**
 * The Class Authentication.
 * @author Yunusbaev R.I.
 */
@WebServlet(name="admin", urlPatterns="/admin")
public class Admin extends HttpServlet {

    /**
     * Do post.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestAuth Auth = RequestAuth.fromRequestParameters(request);
        Auth.setAsRequestAttributesAndCalculate(request, response);
    }

    /**
     * The Class RequestAuth.
     */
    private static class RequestAuth {

        /** The username. */
        private String power;

        /** The password. */
        private String powerNumber;

        /** The username password. */
        private HashMap<String, String> username_password = new HashMap<>();

        /**
         * Instantiates a new request auth.
         *
         * @param power the power
         * @param powerNumber the powerNumber
         */
        public RequestAuth(String power, String powerNumber) {
            this.power = power;
            this.powerNumber = powerNumber;
        }

        /**
         * From request parameters.
         *
         * @param request the request
         * @return the request auth
         */
        public static RequestAuth fromRequestParameters(HttpServletRequest request) {
            return new RequestAuth(
                    request.getParameter("power"),
                    request.getParameter("powerNumber"));
        }

        /**
         * Sets the as request attributes and calculate.
         *
         * @param request the request
         * @param response the response
         * @throws ServletException the servlet exception
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("power", power);
            request.setAttribute("powerNumber", powerNumber);
            request.setAttribute("error", "Коэффициенты: " +
                    Calculation.power_100 + "\n" +
                    Calculation.power_150 + "\n" +
                    Calculation.power_200 + "\n" +
                    Calculation.power_250 + "\n" +
                    Calculation.power_999);

            switch (power) {
                case "Меньше 100":
                    Calculation.power_100 = Integer.parseInt(powerNumber);
                    break;
                case "Между 100 и 150":
                    Calculation.power_150 = Integer.parseInt(powerNumber);
                    break;
                case "Между 150 и 200":
                    Calculation.power_200 = Integer.parseInt(powerNumber);
                    break;
                case "Между 200 и 250":
                    Calculation.power_250 = Integer.parseInt(powerNumber);
                    break;
                case "Больше 250":
                    Calculation.power_999 = Integer.parseInt(powerNumber);
                    break;
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
    }
}