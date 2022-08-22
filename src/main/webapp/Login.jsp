<%--
  Created by IntelliJ IDEA.
  User: juanb
  Date: 22/08/2022
  Time: 1:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Controller.UsuarioControlador"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="Usuario" method="post">

  <span>Usuario</span>
  <input type="text" name="textUsuario" placeholder="Ingresar Usuario" required>
  <br>
  <span>Contraseña</span>
  <input type="password" name="textClave" placeholder="Ingresar Clave" required>
  <br>
  <button type="submit">Hecho</button>
  <input type="hidden" value="1" name="opcion">

</form>

</body>
</html>
