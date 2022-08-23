package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modelDAO.LoginDAO;
import modelVO.LoginVO;

import java.io.IOException;

@WebServlet(name = "LoginControlador", value = "/LoginControlador")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuario = request.getParameter("txtId");
        String nombreUsuario = request.getParameter("txtUser");
        String passwordUsuario = request.getParameter("txtPassword");
        String rolUsuario = request.getParameter("rol");
        String btnEnter = request.getParameter("btnEnter");

        LoginVO logVO = new LoginVO(idUsuario, nombreUsuario, passwordUsuario);
        LoginDAO logDAO = new LoginDAO(logVO);

        if (btnEnter.equals("Ingresar")) {
            String[] validarLogin = logDAO.validarLogin(nombreUsuario, passwordUsuario);
            if (validarLogin[1] == "true") {

                String rol = logDAO.consultarRol(nombreUsuario, passwordUsuario);
                logVO = new LoginVO(String.valueOf(validarLogin[0]), nombreUsuario, passwordUsuario, String.valueOf(rol));

                if (rol != null) {
                    if (rol == "admin") {
                        request.setAttribute("rol", logVO);
                        request.getRequestDispatcher("indexAdmin.jsp").forward(request, response);
                    } else if (rol == "artista") {
                        request.setAttribute("rol", logVO);
                        request.getRequestDispatcher("indexArtista.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensajeError", "usuario no tiene rol");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensajeError", "credenciales incorrectas");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
}
