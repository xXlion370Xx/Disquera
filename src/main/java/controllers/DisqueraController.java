package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modelDAO.DisqueraDAO;
import modelVO.DisqueraVO;

import java.io.IOException;

@WebServlet(name = "Disquera", value = "/Disquera")
public class DisqueraController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //recibir datos de las vistas
        String nitDisquera = request.getParameter("txtNit");
        String nombreDisquera = request.getParameter("txtName");
        String telefonoDisquera = request.getParameter("txtTel");
        String direccionDisquera = request.getParameter("txtDir");
        String estadoDisquera = request.getParameter("txtEstado");
        String btnOpcion = request.getParameter("btnOpcion");

        //Almacenar los datos de forma segura con el VO
        DisqueraVO disVO = new DisqueraVO(nitDisquera, nombreDisquera,telefonoDisquera,direccionDisquera,estadoDisquera);
        //Operaciones
        DisqueraDAO disDAO = new DisqueraDAO(disVO);

        switch (btnOpcion){

            case "Agregar":
                if (disDAO.agregarRegistro()){
                    request.setAttribute("mensajeExito","La disquera se agrego correctamente");
                }
                else {
                    request.setAttribute("mensajeError", "La disquera no se pudo agregar");
                }
                request.getRequestDispatcher("registrarDisquera.jsp").forward(request,response);
                break;
            case "Consultar":
                disVO = disDAO.consultarNit(nitDisquera);
                if (disVO != null){
                    request.setAttribute("disqueraConsultada", disVO);
                    request.getRequestDispatcher("disqueraConsultada.jsp").forward(request,response);
                } else {
                    request.setAttribute("mensajeError", "disquera no existe");
                    request.getRequestDispatcher("consultarDisquera.jsp").forward(request,response);
                }

        }

    }
}
