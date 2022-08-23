<%@ page import="modelVO.DisqueraVO" %><%--
  Created by IntelliJ IDEA.
  User: Meru
  Date: 23/08/2022
  Time: 8:10 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehiculo consultado</title>
</head>
<body>
    <h3>el siguiente vehiculo fue hayado: </h3>


    <table>
        <tr>
            <th>NIT</th>
            <th>NOMBRE</th>
            <th>TELEFONO</th>
            <th>DIRECCION</th>
            <th>ESTADO</th>
            <th>ACCION</th>
        </tr>
        </thead>
        <tbody>
            <%
                if (request.getAttribute("disqueraConsultada") != null){
                    DisqueraVO disVO = (DisqueraVO)  request.getAttribute("disqueraConsultada") ;
            %>
            <tr>
                <td><%=disVO.getNitDisquera()%></td>
                <td><%=disVO.getNombreDisquera()%></td>
                <td><%=disVO.getTelefonoDisquera()%></td>
                <td><%=disVO.getDireccionDisquera()%></td>
                <td><%=disVO.getEstadoDisquera()%></td>
                <td></td>
            </tr>
        <%}%>
        </tbody>
    </table>

</body>
</html>
