package com.example.bmical;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BMICal")
public class BMICal extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BMICal() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BMI Calculator</title>");
        out.println("<style>");
        out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #2b5876, #4e4376); color: white; text-align: center; margin: 0; padding: 0; height: 100vh; display: flex; justify-content: center; align-items: center;}");
        out.println(".container { background: rgba(255, 255, 255, 0.1); padding: 20px; border-radius: 15px; width: 350px; margin: auto; box-shadow: 0 4px 10px rgba(0,0,0,0.2); }");
        out.println("label { font-weight: bold; display: block; text-align: left; margin: 10px 0 5px; }");
        out.println("input[type='number'] { padding: 10px; width: 94%; border-radius: 5px; border: none; margin-bottom: 10px; }");
        out.println("button { width: 100%; margin-top: 10px; padding: 12px; border: none; border-radius: 5px; background: #ff9800; color: white; font-size: 16px; cursor: pointer; }");
        out.println("button:hover { background: #e68900; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>BMI Calculator</h2>");
        out.println("<form method='POST' action='BMICal'>");
        out.println("<label for='height'>Height (m):</label>");
        out.println("<input type='number' step='0.01' id='height' name='height' required>");
        out.println("<label for='weight'>Weight (kg):</label>");
        out.println("<input type='number' step='0.1' id='weight' name='weight' required>");
        out.println("<button type='submit'>Calculate BMI</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            double height = Double.parseDouble(request.getParameter("height"));
            double weight = Double.parseDouble(request.getParameter("weight"));

            if (height <= 0 || weight <= 0) {
                out.println("<h2>Error: Height and weight must be greater than zero.</h2>");
                out.println("<a href='BMICal'>Back</a>");
                return;
            }

            double bmi = weight / (height * height);
            String status;

            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 24.9) {
                status = "Normal weight";
            } else if (bmi < 29.9) {
                status = "Overweight";
            } else {
                status = "Obesity";
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BMI Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #2b5876, #4e4376); color: white; text-align: center; margin: 0; padding: 0; height: 100vh; display: flex; justify-content: center; align-items: center;}");
            out.println(".result-box { background: rgba(255, 255, 255, 0.2); padding: 20px; border-radius: 15px; width: 350px; margin: auto; box-shadow: 0 4px 10px rgba(0,0,0,0.2); }");
            out.println("h2 { color: #ffcc00; }");
            out.println(".back-link { display: inline-block; margin-top: 15px; color: #ffcc00; text-decoration: none; font-weight: bold; }");
            out.println(".back-link:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='result-box'>");
            out.println("<h2>Your BMI: " + String.format("%.2f", bmi) + "</h2>");
            out.println("<h3>Status: " + status + "</h3>");
            out.println("<a href='BMICal' class='back-link'>Back to Calculator</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            out.println("<h2>Error: Invalid input. Please enter numeric values.</h2>");
            out.println("<a href='BMICal'>Back</a>");
        }
    }
}
