package com.SessionCookie1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/GradeValidationFilter")

public class GradeValidationFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
   
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
      
        String subject1 = request.getParameter("subject1");
        String subject2 = request.getParameter("subject2");
        String subject3 = request.getParameter("subject3");
        
        // Validate marks
        if (isValidMarks(subject1) && isValidMarks(subject2) && isValidMarks(subject3)) {
            chain.doFilter(request, response); 
        } else {
       
        	 httpResponse.sendRedirect("Error.html");
        }
    }

    public void destroy() {
        
    }

    private boolean isValidMarks(String marks) {
        try {
            int mark = Integer.parseInt(marks);
            return mark >= 0 && mark <= 100; 
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
