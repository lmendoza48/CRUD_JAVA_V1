<%--
  Created by IntelliJ IDEA.
  User: lamendoza
  Date: 04/05/2017
  Time: 01:35 PM
  To change this template use File | Settings | File Templates.
  here Todo: este es mi segundo jsp donde muestro los datos por end-point
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="/WEB-INF/tld/spring-form.tld" %>
<html>
<head>
    <title>Page For Buy Bici</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
    <script>
        function myFunction(obj) {
            if ( obj === "1") {
                document.getElementById("first_name1").style.display = "block";
                document.getElementById("hours").style.display = "none";
                document.getElementById("days").style.display = "none";
            }else{
                document.getElementById("first_name1").style.display = "none";
                document.getElementById("hours").style.display = "none";
                document.getElementById("days").style.display = "none";
            }
        }

        function myFunctionType(obj) {
            if(obj === "hours"){
                document.getElementById("days").style.display = "none";
                document.getElementById("hours").style.display = "block";
            }else if(obj === "days") {
                document.getElementById("hours").style.display = "none";
                document.getElementById("days").style.display = "block";
            }
        }
        window.onload = function () {
            myFunction("1");
        };
    </script>
</head>
<body>
<%-- old information end - point example
<p>${someAttribute}</p>--%>

<div class="container">
    <div class="card-panel teal lighten-2">
        <i align="center" class="material-icons prefix">directions_bike</i>
        <h4>Complete los datos</h4>
        <%--<div class="card-panel">
          <div class="row">
            <div class="input-field col s6">
              <select id="selectName" onchange="myFunction(this.value);">
                <option value="" disabled selected>Choose family group or one person</option>
                <option value="1" >Family Group</option>
                <option value="2" >One Person</option>
              </select>
              <label>Select Type</label>
            </div>
          </div>
        </div>--%>
        <!--form-->
        <div class="card-panel" id="first_name1">
            <div class="row">
                <spring:form action="saveData" method="post" modelAttribute="StoryData" class="col s12">
                    <div class="row">
                        <spring:hidden path="id"/>
                        <div class="input-field col s8">
                            <spring:input path="nameUser" id="first_name" type="text" class="validate" />
                            <label>Full Name</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s8">
                            <spring:input path="dniPassport" id="dni_name" type="text" class="validate" />
                            <label>DNI o Passaport</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s8">
                            <spring:input path="email" id="email_data" type="email" class="validate"/>
                            <label>Email</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s8">
                            <spring:input path="countBike" id="bike_cantid" type="number" class="validate" />
                            <label>Cantidad de Bike</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s8">
                            <spring:input path="address" id="address" type="text" class="validate" />
                            <label>Address</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <select id="selectClock" onchange="myFunctionType(this.value);">
                                <option value="" disabled selected>Choose Days or Hours</option>
                                <option value="days" >Days</option>
                                <option value="hours" >Hours</option>
                            </select>
                            <label>Select Type</label>
                        </div>
                    </div>
                    <div class="row" id="days">
                        <div class="input-field col s6">
                            <input id="firstDay" type="text" >
                            <label>Select Days</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="lastDay" type="text" onblur="calcutationByHour()" >
                            <label for="lastDay">Select Days</label>
                        </div>
                    </div>
                    <spring:hidden path="totalDay" value="totaldayFinish"/>
                    <div class="row" id="hours">
                        <div class="input-field col s6">
                            <select id="selectHours" onchange='calcutationByHour();'>
                                <option value="" disabled selected>Select Hours</option>
                                <option value="1" >1 Hrs</option>
                                <option value="2" >2 Hrs</option>
                                <option value="4" >4 Hrs</option>
                                <option value="8" >8 Hrs</option>
                                <option value="10" >10 Hrs</option>
                                <option value="12" >12 Hrs</option>
                                <option value="14" >14 Hrs</option>
                                <option value="16" >16 Hrs</option>
                                <option value="18" >18 Hrs</option>
                                <option value="20" >20 Hrs</option>
                            </select>
                            <label>Select Type</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <spring:input path="totalCount" id="ftotalIn" type="text" class="validate" value="" />
                            <label>Total Payment</label>
                        </div>
                    </div>
                    <input class="btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                    </input>
                </spring:form>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('select').material_select();

        $('#firstDay').blur(function(){
            var ex =$("#firstDay").val();
            $("#lastDay").val(ex);
        });
    });

    function calcutationByHour() {
        var y = document.getElementById("firstDay");
        var x = document.getElementById("lastDay");
        var to = document.getElementById("selectHours");
        var numC;
        if(x.value != "" && y.value != "" ){
            alert("into" + y.value + x.value );
            var dy = restarFechas(x, y);
            numC = dy;
        }else{
            numC = to.value;
        }

        alert("hello___" + numC );

        if (numC == 4) {
            ftotalIn.value = "80$";
        }
    }
    function restarFechas(xcc,yccc) {
        var num2 = xcc.value;
        var num1 = yccc.value;
        var aFecha1 = num1.split("/");
        var aFecha2 = num2.split("/");
        var fFecha1 = Date.UTC(aFecha1[2],aFecha1[1]-1,aFecha1[0]);
        var fFecha2 = Date.UTC(aFecha2[2],aFecha2[1]-1,aFecha2[0]);
        var dif = fFecha2 - fFecha1;
        var dias = Math.floor(dif / (1000 * 60 * 60 * 24));
        return dias;
    }

</script>
</body>
</html>

