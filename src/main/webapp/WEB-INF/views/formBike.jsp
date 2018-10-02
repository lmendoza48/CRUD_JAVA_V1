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
                                <option value="days" >Días</option>
                                <option value="hours" >Horas</option>
                                <option value="weeks" >Semanas</option>
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
                    <a href="listData" class="waves-effect waves-light btn"><i class="material-icons left">tablet</i> Ver Datos </a>
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
       //var countComplet = numberBike*50;
        var porcentage = 0;
        var ptotalPay = 0;
        var ptotalPay2 = 0;

       if(dayOrHrs == "days"){
          if(time > 7){
              alert("No puede ser mayor a 7 dias!!!!!!");
              document.getElementById("selectClock").value = "";
          }else{
              countComplet = gettotalCountData(20,numberBike,time);
          }
          document.getElementById("payTotal").value = countComplet;

       }else if(dayOrHrs == "hours"){
           if(time > 24){
               alert("No puede ser mayor a 24 hrs!!!!!!");
               document.getElementById("selectClock").value = "";
           }else{
               countComplet = gettotalCountData(5,numberBike, time);
               document.getElementById("payTotal").value = countComplet;
           }
       }else{
           if(time > 4){
               alert("No puede ser mayor a 4 semanas!!!!!!");
               document.getElementById("selectClock").value = "";
           }else{
               countComplet = gettotalCountData(60,numberBike,time);
           }
       }

   }

    function gettotalCountData(day, numberBike,time){
        var ptotalPay = 0;
        var ptotalPay2 = 0;
        var countCompletData = 0;
            if(numberBike >= 3 && numberBike <= 5){
                ptotalPay = time*day;
                ptotalPay2 = ptotalPay*0.30;
                countCompletData = ptotalPay + ptotalPay2;
            }else {
                countCompletData = time * day;
            }
            return countCompletData;
    }
</script>
</body>
</html>