<%@ page import="java.util.ArrayList" %>
<%@ page import="com.disquera.models.MusicVO" %><%--
  Created by IntelliJ IDEA.
  User: lion3
  Date: 21/08/2022
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mi musica</title>
</head>
<body>
<h1>Tus canciones</h1>
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
    <table>
        <tr>
            <th>Nombre</th>
            <th>Fecha</th>
            <th>Duracion</th>
            <th>Album</th>
            <th>Estado</th>
        </tr>
        <%
            ArrayList<MusicVO> listMusic = (ArrayList<MusicVO>) request.getAttribute("listMusic");

            for (MusicVO m : listMusic){
        %>
        <tr>
            <td><%=m.getName()%></td>
            <td><%=m.getRecordDate()%></td>
            <td><%=m.getRecordingTime()%></td>
            <td><%=m.getIdAlbum()%></td>
            <td><%=m.getStatus()%></td>
        </tr>
        <%
            }
        %>
    </table>
    </div>
    <div class="footer">
        <img src="#" alt="logo">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid eveniet maxime modi nihil porro, reiciendis. Cum, dolorem earum facilis id, impedit magnam non nostrum, obcaecati perferendis sapiente sequi sunt voluptas?

    </div>
</div>


</body>
</html>
