<%-- 
    Document   : pass
    Created on : 16/10/2021, 08:41:56
    Author     : Tayanne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<core:url value="entrada?acao=LoginPass" var="linkLogin" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora JSP</title>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                    <div class="column md-3">
                    <h3>Índice de Massa Corpórea</h3>
                    <form action="${linkLogin}" method="POST" class="d-inline-flex flex-column">
                        <input type="hidden" name="acao" value="Login"/>
                        <label>Informe sua senha de acesso: </label>
                        <br>
                        <input type="password" name="txtSenha">
                        <br><br>
                        <label hidden>Botão para enviar</label>
                        <input type="submit" name="btnEnviar" value="Enviar">
                    </form>
                </div>
            </div>
        </div>  
                        
    </body>
</html>
