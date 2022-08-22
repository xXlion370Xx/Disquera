package Controller;

import Models.UsuarioDAO;
import Models.UsuarioVO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletUsuarioControlador", value = "/Usuario")
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idUsuario = request.getParameter("textId");
        String nombreUsuario = request.getParameter("textUsuario");
        String passwordUsuario = request.getParameter("textClave");
        String rolUsuario = "";
        String estadoUsuario = "";
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quién tiene los datos de forma segura? VO
        UsuarioVO usuVO = new UsuarioVO(idUsuario, nombreUsuario, passwordUsuario, rolUsuario, estadoUsuario);

        //3. ¿Quién hace las operaciones? DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        switch (opcion) {

            case 1: //Iniciar sesion

                if (usuDAO.iniciarSesion(nombreUsuario, passwordUsuario)) {

                    HttpSession miSesion = request.getSession(true);
                    UsuarioDAO USUD = new UsuarioDAO(usuVO);
                    UsuarioVO use = USUD.consultarUsuario(nombreUsuario, passwordUsuario);
                    usuVO = new UsuarioVO(idUsuario, nombreUsuario, passwordUsuario, rolUsuario, estadoUsuario);
                    miSesion.setAttribute("datosUsuario", usuVO);
                    miSesion.setAttribute("idUsuario", usuVO.getIdUsuario());
                    request.getRequestDispatcher("Album.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeExito", "<center><h2>Datos de ingreso incorrectos</h2></center>");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                break;
        }

    }
}
