<%--
  Created by IntelliJ IDEA.
  User: Meru
  Date: 23/08/2022
  Time: 12:52 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>agregar disquera</title>
</head>
<body>
    <form method="post" action="Disquera">
        <tr>
            <th>
                <p>NIT disquera</p><br>
                <input type="text" name="txtNit" required>
                <p>Nombre</p><br>
                <input type="text" name="txtName" required>
                <p>Telefono</p><br>
                <input type="tel" name="txtTel" required>
                <p>Direccion</p><br>
                <input type="text" name="txtDir" required>
                <p>Estado</p><br>
                <select name="txtEstado" id="estado" required>
                    <option value="Activo">Activo</option>
                    <option value="Inactivo">Inactivo</option>
                </select>
            </th>
        </tr>
        <input type="submit" value="Agregar" name="btnOpcion">
    </form>
    <%
        if (request.getAttribute("mensajeError") != null) {
    %>
        ${mensajeError}
    <% } else {%>
    ${mensajeExito}
    <%}%>
</body>
</html>
