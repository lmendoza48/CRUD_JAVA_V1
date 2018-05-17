<%--
  Created by IntelliJ IDEA.
  User: WKP
  Date: 24/04/2018
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
</head>
<body>
<div class="container">
    <div class="card-panel teal lighten-2">
        <div align="center">
            <h4>Complete los datos: <i class="material-icons prefix left">directions_bike</i> </h4>
        </div>
          <div class="card-panel" id="first_name1">
             <div class="row">
                <form:form action="saveData" method="post" modelAttribute="orderData">
                    <form:hidden path="idOrder"/>
                    <div class="row">
                        <div class="input-field col s8">
                            <label for="address">Address:</label>
                            <form:input path="address"  type="text" class="validate"
                                        id="address"  name="address" required="required" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s8">
                            <label for="countBike">Count Bike:</label>
                            <form:input path="countBike" type="number" class="validate"
                                        id="countBike" name="countBike" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <label for="totalDay">Rental Day:</label>
                            <form:input path="totalDays"  type="number" class="validate"
                                        id="totalDay"  name="totalDay" />
                        </div>
                        <div class="input-field col s6">
                            <select id="selectClock" onchange="getDatabytotalAccount()">
                                <option value="" disabled selected>Choose Days or Hours</option>
                                <option value="days" >Days</option>
                                <option value="hours" >Hours</option>
                            </select>
                            <label>Select Type</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s8">
                            <label for="payTotal">Total De Pay:</label>
                            <form:input path="totalPay" type="text" class="validate"
                                        id="payTotal" name="payTotal" />
                        </div>
                    </div>
                    <button type="submit" class="waves-effect waves-light btn" ><i class="material-icons">assignment_returned</i> Guardar </button>
                    <a href="backTo" class="waves-effect waves-light btn light-blue lighten-1">
                        <i class="material-icons left">cancel</i>Cancel
                    </a>
                </form:form>
            </div>
        </div>
    </div>
</div>

<script type="application/javascript" >

    $(document).ready(function() {
        $('select').material_select();
    });

    function getDatabytotalAccount() {

       var dayOrHrs = document.getElementById("selectClock").value;
       var time = document.getElementById("totalDay").value;
       var numberBike = document.getElementById("countBike").value;
       var countComplet = numberBike*50;
       var porcentage = 0;

       if(dayOrHrs == "days"){
           var totalDay = time*25;
          if(time == 5){
              porcentage = totalDay*0.05;
              totalDay = totalDay - porcentage;
          }else if(time == 10 ){
              porcentage = totalDay*0.15;
              totalDay = totalDay - porcentage;
          }else if (time == 15 ){
              porcentage = totalDay*0.20;
              totalDay = totalDay - porcentage;
          }
          countComplet = totalDay + countComplet;
          document.getElementById("payTotal").value = countComplet;

       }else{
           if(time > 24){
               alert("No puede ser mayor a 24 hrs!!!!!!");
               document.getElementById("selectClock").value = "";
           }else{
               countComplet = countComplet + 25;
               document.getElementById("payTotal").value = countComplet;
           }
       }

   }
</script>
</body>
</html>