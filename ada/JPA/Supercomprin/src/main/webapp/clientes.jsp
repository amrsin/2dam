<%-- 
    Document   : clientes
    Created on : 15 ene. 2021, 20:47:41
    Author     : singh
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionClientes,java.util.ArrayList,mx.com.gm.sga.supercomprin.Cliente"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gesti�n de Clientes</title>
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

            button {
                background-color: #922B21; 
                border: 2px solid black;
                color: white;
                padding: 5px 5px;
                text-align: center;
                display: inline-block;
                font-size: 14px;
                margin: 2px 2px;
                
            }
            
            .button1 {
                
                border: none;
                padding: 2px 2px;
                
                
                
            }
            a:link, a:visited, a:active {
                text-decoration:none;
                color: white;
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

        <c:set var="clientes" value="${requestScope.clientes}"/>

        <br/><br/><br/>
        <center><div>

                <button onclick="new_cliente()">Insertar cliente</button>
                <button onclick="update_cliente()">Actualizar cliente</button>
        </center></div>

    <br><br>
    
    <c:choose>

        <c:when test="${!empty clientes}">

            <center><table border="1">
                    <tr>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Email</th>
                        <th>Fecha nacimiento</th>
                        <th>Puntos</th>
                        <th>Saldo</th>
                        <th></th>

                    </tr>

                    <c:forEach var="cli" items="${clientes}">
                        <tr><td>${cli.DNI}</td>
                            <td>${cli.nombre}</td>
                            <td>${cli.apellidos}</td>
                            <td>${cli.email}</td>
                            <td>${cli.fecha_nacimiento}</td>
                            <td>${cli.puntos}</td>
                            <td>${cli.saldo}</td>
                            <td><button class="button button1"><a href="Controller?op=doEliminar_cliente&DNI=${cli.DNI}">Eliminar</button></td>
                        </tr>
                    </c:forEach>

                </table></center>

        </c:when>
        <c:otherwise>
            <center><h1>No hay Clientes</h1></center>
            </c:otherwise>
        </c:choose>
    <br/>
    <br/>

    <script>
        function new_cliente() {
            window.open("new_cliente.html", "new_cliente", "width=600,height=600", false);

        }

        function update_cliente() {
            window.open("update_cliente.html", "update_cliente", "width=600,height=600", false);

        }

    </script>
</html>