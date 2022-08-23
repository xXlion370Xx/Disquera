<%--
  Created by IntelliJ IDEA.
  User: lion3
  Date: 22/08/2022
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar album</title>
</head>
<body>
<div class="container">
    <h1>Nuevo album</h1>
    <div class="content">
        <form action="?" method="post">
            <label>
                Nombre
                <input type="text" name="name" placeholder="Nombre del nuevo album" required> 
            </label>
            <label>
                Fecha de lanzamiento
                <input type="datetime-local" name="date" required><br>
            </label>
            <label>
                <input type="text" name="artist" readonly value="">
            </label>
        </form>
    </div>
</div>
</body>
</html>
