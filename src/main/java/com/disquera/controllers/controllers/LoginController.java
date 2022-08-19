package com.disquera.controllers.controllers;

import com.disquera.controllers.models.LoginModelDAO;
import com.disquera.controllers.models.LoginModelVO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "LoginController", value = {"/Login"})

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request HTTP post from views
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        int option = parseInt(request.getParameter("option"));


        // Instantiate objects models
        LoginModelVO loginModelVO = new LoginModelVO(user, password);
        LoginModelDAO loginModelDAO = new LoginModelDAO(loginModelVO);

        boolean validateLogin = false;
        // Management data

        switch (option){
            case 1:
                try {
                    validateLogin = loginModelDAO.validateLogin();
                    if (validateLogin){
                        request.getRequestDispatcher("artista.jsp").forward(request, response);
                    }
                    request.setAttribute("mensajeError", "Error, intentalo nuevamente");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                request.setAttribute("mensajeError", "Algo salio mal");
                request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

}
