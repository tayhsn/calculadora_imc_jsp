<%-- 
    Document   : calculadora
    Created on : 16/10/2021, 08:39:52
    Author     : Tayanne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<core:url value="entrada?acao=Calcular" var="linkCalcular"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="../styles/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

        <title>CALCULADORA JSP</title>
    </head>
    <body>

        <div class="container d-sm-flex flex-column justify-content-center">
            <h2>Calcule seu IMC</h2>
            <div class="d-inline-flex flex-column">
                <form action="${linkCalcular}" method="POST">
                    <div>
                        <label for="formGroupInput" class="form-label">Qual sua altura?</label>
                        <input type="text" class="d-inline" name="inputAltura" placeholder="Ex: 1.60">
                    </div>
                    <div>
                        <label for="formGroupInput2" class="form-label">Qual seu peso?</label>
                        <input type="text" class="d-inline" name="inputPeso" placeholder="Ex: 62.5">
                    </div>
                    <button type="submit" class="btn btn-dark">Calcular</button>
                </form>
                <div class="d-inline-flex m-2">
                    <div>
                        <fmt:formatNumber maxFractionDigits="2" var="IMCformat" value="${IMC}" />
                        <p>Resultado:</p>
                        <input readonly value="${IMCformat}">
                    </div>
                    <div>
                        <p>Classificação:</p>
                        <input readonly value="${classificacao}">
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    </body>
</html>
