package com.disquera.controllers.controllers;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginController", value = "/Login")
public class LoginController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + user + " " + password + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}