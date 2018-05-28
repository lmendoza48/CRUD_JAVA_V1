<%--
  Created by IntelliJ IDEA.
  User: WKP
  Date: 08/05/2018
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
    <style>
        #userAllstyle{
            position: relative;
            top: 33px;
            left: 11px;
        }
    </style>
</head>
<body>
<div class="container col s5">
    <div class="card-panel" id="userAllstyle">
      <div class="row" id="formUser" align="center">
        <form action="<c:url value='j_spring_security_check' />" method="post">
            <c:if test="${not empty error}">
                <div class="row" id="message">
                    <div class="card-panel teal lighten-2">Erro with Login</div>
                </div>
            </c:if>
            <div class="row">
                <div class="input-field col s10">
                    <input id="username" type="text" name="username" class="validate" onfocus="clearData()">
                    <label for="username">User Name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s10">
                    <input id="password" type="password" name="password" class="validate">
                    <label for="password">Password</label>
                </div>
            </div>
            <input type="hidden" value="ID_Role">
            <a href="user/formInfo" class="waves-effect waves-light btn"><i class="material-icons left">cloud</i>Registrar</a>
            <button type="submit" class="waves-effect waves-light btn" > Login </button>
        </form>
     </div>
   </div>
</div>
<script>
    function  clearData() {
        document.getElementById("message").style.display = "none";
    }
</script>

</body>
</html>
