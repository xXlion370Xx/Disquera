package com.disquera.controllers.controllers;

import com.disquera.controllers.models.UserModelDAO;
import com.disquera.controllers.models.UserModelVO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserController", value = {"/Login"})

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request HTTP post from views
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // Instantiate objects models
        UserModelVO userModelVO = new UserModelVO(user, password);
        UserModelDAO userModelDAO = new UserModelDAO(userModelVO);

        String[] validateLogin;
        // Management data

            try {
                // Call model method login to validate the user
                validateLogin = userModelDAO.validateLogin();

                if (!(validateLogin == null)) {
                    //Validate if the user is active

                    if(validateLogin[0].equals("Artista") && validateLogin[1].equals("activo")){

                        request.getRequestDispatcher("Artista/artista.jsp").forward(request, response);

                    } else if(validateLogin[0].equals("Artista") && validateLogin[1].equals("inactivo")){

                        request.setAttribute("mensajeError", "Usuario inactivo, por favor contacte con un administrador");
                        request.getRequestDispatcher("index.jsp").forward(request, response);

                    }// Validate the admin
                    else if(validateLogin[0].equals("Administrador")){

                        request.getRequestDispatcher("Administrador/administrador.jsp").forward(request, response);

                    }
                } else {

                    request.setAttribute("mensajeError", "Datos incorrectos");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

}
