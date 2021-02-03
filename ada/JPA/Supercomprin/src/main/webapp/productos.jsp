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
        <style type="text/css">

            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
            li a:hover {
                background-color: #922B21;
            }
        </style>
    </head>
    <body>

        <ul>
            <li><a href="menu.html">Home</a></li>
            <li><a href="Controller?op=doRecuperar_cliente">Clientes</a></li>
            <li><a href="Controller?op=doRecuperar_compra">Compras</a></li>
            <li><a href="Controller?op=doRecuperar_devuelve">Devueltos</a></li>
            <li><a href="Controller?op=doRecuperar_producto">Productos</a></li>
        </ul>

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
    </body>
</html>