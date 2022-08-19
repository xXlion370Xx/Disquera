<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<img src="#" alt="Logo">
<form action="Login" method="post">
    <input type="text" name="user" placeholder="Usuario" required> <br>
    <input type="password" name="password" placeholder="Contraseña" required> <br>
    <input type="hidden" name="option" value="1"> <br>
    <button>INICIAR SESIÓN</button>
    <%
        if (request.getAttribute("mensajeError") !=null) {%>
    <p class="respuestaFalse">${mensajeError}</p>

    <% }else { %>
    <p class="respuestaTrue">${mensajeExito}</p>
    <%}%>
</form>
</body>
</html>