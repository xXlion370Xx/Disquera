<%@ page import="modelVO.DisqueraVO" %>
<%@ page import="modelDAO.DisqueraDAO" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Meru
  Date: 23/08/2022
  Time: 12:28 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consultar disquera</title>
</head>
<body>

    <h3>Consultar disquera por NIT</h3>
    <form method="post" action="Disquera" >
        <input type="text" name="txtNit" placeholder="NIT de la disquera">
        <input type="submit" value="Consultar" name="btnOpcion">
    </form>
    <h3>Disqueras existentes</h3>
    <table>
        <thead>
        <tr>
            <th>NIT</th>
            <th>NOMBRE</th>
            <th>TELEFONO</th>
            <th>DIRECCION</th>
            <th>ESTADO</th>
        </tr>
        </thead>
        <tbody>
            <%
                DisqueraVO disVO = new DisqueraVO();
                DisqueraDAO disDAO = new DisqueraDAO();
                ArrayList<DisqueraVO> listaDisquera = disDAO.listar();
                for (int i = 0; i < listaDisquera.size(); i++){
                    disVO = listaDisquera.get(i);

            %>
        <tr>
            <td><%=disVO.getNitDisquera()%></td>
            <td><%=disVO.getNombreDisquera()%></td>
            <td><%=disVO.getTelefonoDisquera()%></td>
            <td><%=disVO.getDireccionDisquera()%></td>
            <td><%=disVO.getEstadoDisquera()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</body>
</html>
