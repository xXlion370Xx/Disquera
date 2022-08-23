<%--
  Created by IntelliJ IDEA.
  User: juanb
  Date: 22/08/2022
  Time: 1:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Controller.UsuarioControlador"%>
<%@page import="Models.UsuarioVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/Style.css">
    <title>Login</title>
</head>
<body>

<center>
    <form action="Usuario" method="post">
        <img src="./IMG/Logo.png" alt="">
        <br>
        <input type="text" name="textUsuario" placeholder="Correo Electronico" required class="User">
        <br>
        <br>
        <input type="password" name="textClave" placeholder="Contraseña" required class="Pass">
        <br>
        <br>
        <br>
        <div>
            <button type="submit" class="Button">INICIAR SESIÓN</button>
            <input type="hidden" value="1" name="opcion">
            <br>
            <span class="H1">¿Contraseña Olvidada?</span>
        </div>

    </form>
</center>

<%

    if (request.getAttribute("mensajeError") != null) {%>
${mensajeError}
<% } else {%>
${mensajeExito}
<%}%>

</body>
</html>
