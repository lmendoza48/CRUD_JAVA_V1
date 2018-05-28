<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lamendoza
  Date: 04/05/2017
  Time: 01:52 PM
  To change this template use File | Settings | File Templates.
  Jsp principal cuando suba la app
  Version con Proyecto Nuevo
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>BICI-ECO PAGE</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
</head>
<body>
<%
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
%>
<div class="container">
  <div class="card-panel blue lighten-2">
    <div align="center">
        <i class="material-icons prefix">directions_bike</i>
        <h3>BICI-ECO PAGE</h3>
    </div>
    <div class="card-panel">
        <% if(!auth.getPrincipal().equals("anonymousUser")){%>
            <div align="right">
                <a href="user/logout" class="waves-effect waves-light btn blue lighten-4"><i class="material-icons">directions_walk</i></a>
            </div>
        <%}%>
        <h3 class="lime-text text-lighten-2">Homepage</h3>
        <a href="hello" class="btn waves-effect waves-teal"><i class="material-icons left">add</i> Ingresar </a>
        <a href="listData" class="btn waves-effect waves-teal lime darken-2"><i class="material-icons left">tablet</i> Ver Datos </a>
    </div>
  </div>
</div>
</body>
</html>
