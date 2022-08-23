<%@ page import="com.disquera.models.UserModelVO" %><%--
  Created by IntelliJ IDEA.
  User: lion3
  Date: 21/08/2022
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", 0);
%>

<%
    HttpSession session1 = request.getSession();
    String user = "";
    if (session1.getAttribute("userData") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        UserModelVO usuVO = (UserModelVO) session1.getAttribute("userData");
        user = usuVO.getUser();
    }
%>

</body>
</html>
