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

        // Management data
            try {

                if (userModelDAO.validateLogin()){

                // Call model method login to validate the user
                for (UserModelVO userData : userModelDAO.listUserData()) {
                    userModelVO.setId(userData.getId());
                    userModelVO.setUser(userData.getUser());
                    userModelVO.setPassword(userData.getPassword());
                    userModelVO.setRol(userData.getRol());
                    userModelVO.setStatus(userData.getStatus());
                }
                    if(user.equals(userModelVO.getUser()) && password.equals(userModelVO.getPassword())){

                        //Validate if the user is active
                        if (userModelVO.getRol().equals("Artista") && userModelVO.getStatus().equals("inactivo")) {

                            request.setAttribute("mensajeError", "Usuario inactivo, por favor contacte con un administrador");
                            request.getRequestDispatcher("index.jsp").forward(request, response);

                        }else if(userModelVO.getRol().equals("Artista") && userModelVO.getStatus().equals("activo")){

                            HttpSession session = request.getSession(true);
                            session.setAttribute("userData", userModelVO);
                            request.getRequestDispatcher("Artista/artista.jsp").forward(request, response);

                        }// Validate the admin
                        else if(userModelVO.getRol().equals("Administrador")){

                            HttpSession session = request.getSession(true);
                            session.setAttribute("userData", userModelVO);
                            request.getRequestDispatcher("Administrador/administrador.jsp").forward(request, response);

                        }

                    }else {

                        request.setAttribute("mensajeError", "Usuario o contraseña incorrectos");
                        request.getRequestDispatcher("index.jsp").forward(request, response);

                    }
                }else {
                    request.setAttribute("mensajeError", "Usuario no existe");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

}
