<%-- 
    Document   : productos
    Created on : 1 feb. 2021, 14:48:58
    Author     : singh
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionProductos,java.util.ArrayList,mx.com.gm.sga.supercomprin.Producto"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Productos</title>
    </head>
    <body>

        <c:set var="productos" value="${requestScope.productos}"/>

        <br/><br/><br/>
        <c:choose>

            <c:when test="${!empty productos}">

                <center><table border="1">
                        <tr>
                            <th>id_producto</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Puntos</th>   
                        </tr>

                        <c:forEach var="pro" items="${productos}">
                            <tr><td>${pro.id_producto}</td>
                                <td>${pro.nombre}</td>
                                <td>${pro.precio}</td>
                                <td>${pro.puntos}</td>

                            </tr>
                        </c:forEach>

                    </table></center>

            </c:when>
            <c:otherwise>
                <center><h1>No hay Productos</h1></center>
                </c:otherwise>
            </c:choose>
        <br/>
        <br/>
        <center><a href="Controller?op=toMenu">Menu</a></center>

    </body>
</html>