<%--
  Created by IntelliJ IDEA.
  User: Meru
  Date: 20/08/2022
  Time: 10:59 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container" style="text-align: center">
        <div class="card">
            <div class="card-body">
                <form action="LoginControlador" method="post">
                    <h4>Iniciar sesion</h4>
                    <input type="text" name="txtUser" required  class="form-control" placeholder="Ingrese su usuario">
                    <input type="password" name="txtPassword" required class="form-control" placeholder="Ingrese su contraseña">
                    <input type="submit" name="btnEnter" value="Ingresar" class="btn btn-primary btn-block">
                </form>

                <%
                    if (request.getAttribute("mensajeError") !=null) {%>
                ${mensajeError}
                <% }else { %>
                ${mensajeExito}
                <%}%>

            </div>
        </div>
    </div>
</body>
</html>
