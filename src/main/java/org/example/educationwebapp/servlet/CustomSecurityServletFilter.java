package org.example.educationwebapp.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CustomSecurityServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        if(path.contains("jsp")){
            response.sendRedirect("index");
            return;
        }
        if (path.contains("login") || path.contains("css") || path.contains("js")) {
            filterChain.doFilter(request, response);
            return;
        }

        Object loggedInUser = request.getSession().getAttribute("loggedInUser");
        if (loggedInUser == null) {
            response.sendRedirect("login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
