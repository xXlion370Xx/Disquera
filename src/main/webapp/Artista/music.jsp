<%@ page import="com.disquera.controllers.models.MusicVO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lion3
  Date: 21/08/2022
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mi musica</title>
</head>
<body>
<h1>Tu música</h1>
  <table>
    <tr>
      <th>Nombre Canción</th>
      <th>Fecha Grabación</th>
      <th>Duración</th>
      <th>Album</th>
      <th>Estado Canción</th>
    </tr>
    <%
      MusicVO m = new MusicVO();
      ArrayList<MusicVO> musicVO = (ArrayList<MusicVO>) request.getAttribute("listMusic");
      for (MusicVO vo : musicVO) {
        m = vo;
    %>
    <tr>
      <td><%=m.getName()%>
      </td>
      <td><%=m.getRecordDate()%>
      </td>
      <td><%=m.getRecordingTime()%>
      </td>
      <td><%=m.getIdAlbum()%>
      </td>
      <td><%=m.getStatus()%>
      </td>
    </tr>
    <%
      }
    %>
  </table>
</body>
</html>
