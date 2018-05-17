<%--
  Created by IntelliJ IDEA.
  User: WKP
  Date: 11/05/2018
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Registe Page</title>
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
<div class="container col s8">
    <div class="card-panel" id="userAllstyle">
        <div class="row" id="formUser">
            <form:form action="saveUser" method="post" modelAttribute="userData">
                <form:input path="idUser" type="hidden"/>
                <div class="row">
                    <div class="input-field col s10">
                        <form:input path="name" type="text" id="name"  name="name" class="validate" />
                        <label for="name">Name:</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10">
                        <form:input path="dni" id="dni" type="text" name="dni" class="validate" />
                        <label for="dni">DNI or Passport:</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10">
                        <form:input path="email" id="username" type="email" name="username" class="validate" />
                        <label for="username">Email:</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10">
                        <form:input path="password" id="password" type="password" name="password" class="validate" />
                        <label for="username">Password:</label>
                    </div>
                </div>
                <button type="submit" class="waves-effect waves-light btn" > Register </button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
