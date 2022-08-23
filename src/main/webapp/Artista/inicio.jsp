<%@ page import="com.disquera.models.UserModelVO" %><%--
  Created by IntelliJ IDEA.
  User: lion3
  Date: 18/08/2022
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Artista</title>
    <%@include file="../sessions.jsp" %>
</head>
<body>

    <% UserModelVO userModelVO = (UserModelVO) session1.getAttribute("userData");%>

    <h1>Bienvenido <%=userModelVO.getUser()%></h1>
    <div class="container">
        <div class="nav">
            <ul>
                <li>Logo</li>
                <li><a href="Artist?view=home">Inicio</a></li>
                <li><a href="Artist?view=music">Mi Música</a></li>
                <li><a href="Artist?view=album">Mis Álbumes</a></li>
                <li><a href="Artist?vies=profile">Mi Perfil</a></li>
            </ul>
            <a href="Session">Cerrar Sesión</a>
        </div>
        <div class="content">
            <div class="content_img">
                <img src="#" alt="imagen index artista">
            </div>
            <div class="content_menu">
                <h2>¿Qué deseas hacer hoy?</h2>

                <a href="Artist?view=edit-album">
                    <img src="#" alt="Icono descriptivo">
                    Editar albums
                </a>
                <a href="Artist?view=add-album">
                    <img src="#" alt="Icono descriptivo">
                    Agregar albums
                </a>
                <a href="Artist?view=edit-song">
                    <img src="#" alt="Icono descriptivo">
                    Editar tus canciones
                </a>
                <a href="Artist?view=add-song">
                    <img src="#" alt="Icono descriptivo">
                    Agregar nuevas canciones
                </a>
            </div>
        </div>
        <div class="footer">
            <img src="#" alt="logo">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid eveniet maxime modi nihil porro, reiciendis. Cum, dolorem earum facilis id, impedit magnam non nostrum, obcaecati perferendis sapiente sequi sunt voluptas?

        </div>
    </div>
</body>
</html>
