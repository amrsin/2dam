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
                background-color: #111;
            }
            
            button {
                background-color: #5D6D7E; 
                border: none;
                color: white;
                padding: 10px 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                margin: 4px 2px;
                cursor: pointer;
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

    <script>
        function new_compra() {
            window.open("new_compra.html", "new_compra", "width=900,height=400", false);

        }
    </script>

</body>
</html>