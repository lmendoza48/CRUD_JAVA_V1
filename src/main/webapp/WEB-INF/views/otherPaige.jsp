<%--
  Created by IntelliJ IDEA.
  User: lamendoza
  Date: 14/08/2017
  Time: 01:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>List Data</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!--Materialize ...-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
  <h1>Information all Data</h1>
</div>
<!--Tabla de ejemplo con los datos de mi model-->
<div class="container">
      <table class="striped" align="center">
        <thead>
        <tr>
          <th>Addres</th>
          <th>Cantidad de Bicis</th>
          <th>Total dias de alquiler</th>
          <th>Pago Total</th>
        </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${listBike.size() > '0'}">
              <c:forEach items="${listBike}" var="listAllData">
              <tr>
                <td>${listAllData.address}</td>
                <td>${listAllData.countBike}</td>
                <td>${listAllData.totalDays}</td>
                <td>${listAllData.totalPay}</td>
                <td>
                  <a href="${listAllData.idOrder}" class="btn-floating btn-medium waves-effect waves-light indigo lighten-3"><i class="material-icons">update</i></a>
                </td>
                <td>
                <a id="deleteElemet" onclick="getElementDelete(${listAllData.idOrder})" class="btn-floating btn-medium waves-effect waves-light red"><i class="material-icons">delete</i></a>
                </td>
              </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td></td>
                <td></td>
                <td>No Hay datos que mostrar</td>
                <td></td>
                <td></td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table><br>
  <a href="backTo" class="waves-effect waves-light btn"><i class="material-icons">arrow_back</i> Regresar </a>
</div>
<script type="application/javascript" >

  function getElementDelete(idname) {

      var r = confirm("Esta seguro de borrar este elemento!!!!!!");
      if (r === true) {
          window.location.href = "deleteUser?id="+idname;
      }
  }

</script>
</body>
</html>
