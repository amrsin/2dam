<%-- 
    Document   : devueltos
    Created on : 31 ene. 2021, 14:35:07
    Author     : singh
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionDevueltos,java.util.ArrayList,mx.com.gm.sga.supercomprin.Devuelve"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Compras</title>
    </head>
    <body>

        <c:set var="devueltos" value="${requestScope.devueltos}"/>

        <br/><br/><br/>
        <center><div>

                <button onclick="new_devuelto()">Devolver compra</button>

        </center></div>

    <br><br>
    <c:choose>

        <c:when test="${!empty devueltos}">

            <center><table border="1">
                    <tr>
                        <th>id_devuelto</th>
                        <th>DNI cliente</th>
                        <th>id_producto</th>
                        <th>Fecha</th>
                        <th>Puntos</th>
                        <th>Importe</th>
                        <th></th>

                    </tr>

                    <c:forEach var="dev" items="${devueltos}">
                        <tr><td>${dev.id_compra}</td>
                            <td>${dev.cliente}</td>
                            <td>${dev.id_producto}</td>
                            <td>${dev.fecha}</td>
                            <td>${dev.puntos}</td>
                            <td>${dev.importe}</td>
                        </tr>
                    </c:forEach>

                </table></center>

        </c:when>
        <c:otherwise>
            <center><h1>No hay compras devueltas</h1></center>
            </c:otherwise>
        </c:choose>
    <br/>
    <br/>
    <center><a href="Controller?op=toMenu">Menu</a></center>

    <script>
        function new_devuelto() {
            window.open("new_devuelto.html", "new_devuelto", "width=900,height=400", false);

        }
    </script>

</body>
</html>
