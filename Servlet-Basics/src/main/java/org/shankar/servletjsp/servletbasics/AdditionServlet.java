package org.shankar.servletjsp.servletbasics;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AdditionServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        if (servletRequest.getParameter("number1") != null || servletRequest.getParameter("number2") != null) {
            Long number1 = Long.parseLong(servletRequest.getParameter("number1"));
            Long number2 = Long.parseLong(servletRequest.getParameter("number2"));

            PrintWriter out = servletResponse.getWriter();
            out.println("The sum is : " + (number1 + number2));
        }
    }
}
