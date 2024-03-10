package com.SessionCookie1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GradeCalculator")
public class GradeCalculator extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String subject1 = request.getParameter("subject1");
        String subject2 = request.getParameter("subject2");
        String subject3 = request.getParameter("subject3");
        
        int mark1 = Integer.parseInt(subject1);
        int mark2 = Integer.parseInt(subject2);
        int mark3 = Integer.parseInt(subject3);
        double average = (mark1 + mark2 + mark3) / 3.0;
        
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else if (average >= 50) {
            grade = "E";
        } else {
            grade = "Error";
        }
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Grade Calculator</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Your Marks:</h3>");
        out.println("<p>Subject 1: " + subject1 + "</p>");
        out.println("<p>Subject 2: " + subject2 + "</p>");
        out.println("<p>Subject 3: " + subject3 + "</p>");
        out.println("<h3>Average Grade: " + grade + "</h3>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
