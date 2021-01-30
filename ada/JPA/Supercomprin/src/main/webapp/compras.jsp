<%-- 
    Document   : compra
    Created on : 30 ene. 2021, 9:22:38
    Author     : singh
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionCompras,java.util.ArrayList,mx.com.gm.sga.supercomprin.Compra"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Compras</title>
    </head>
    <body>

        <c:set var="compras" value="${requestScope.compras}"/>

        <br/><br/><br/>
        <center><div>

                <button onclick="new_compra()">Pagar compra</button>

        </center></div>

    <br><br>
    <c:choose>

        <c:when test="${!empty compras}">

            <center><table border="1">
                    <tr>
                        <th>id_compra</th>
                        <th>DNI cliente</th>
                        <th>id_producto</th>
                        <th>Fecha</th>
                        <th>Puntos</th>
                        <th>Importe</th>
                        <th></th>

                    </tr>

                    <c:forEach var="com" items="${compras}">
                        <tr><td>${com.id_compra}</td>
                            <td>${com.cliente}</td>
                            <td>${com.id_producto}</td>
                            <td>${com.fecha}</td>
                            <td>${com.puntos}</td>
                            <td>${com.importe}</td>
                            <td><button><a href="Controller?op=doEliminar_compra&id_compra=${com.id_compra}">Eliminar</button></td>
                        </tr>
                    </c:forEach>

                </table></center>

        </c:when>
        <c:otherwise>
            <center><h1>No hay Compras</h1></center>
            </c:otherwise>
        </c:choose>
    <br/>
    <br/>
    <center><a href="Controller?op=toMenu">Menu</a></center>

    <script>
        function new_compra() {
            window.open("new_compra.html", "new_compra", "width=500,height=500", false);

        }
    </script>

</body>
</html>