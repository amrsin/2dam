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
        <title>Gestión de Clientes</title>
    </head>
    <body>

        <c:set var="clientes" value="${requestScope.clientes}"/>

        <br/><br/><br/>
        <center><button onclick="new_cliente()">Insertar cliente</center></button>
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
                                <td><a href="Controller?op=doEliminar_cliente&DNI=${cli.DNI}">Eliminar</button></td>
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
        <center><a href="Controller?op=toMenu">Menu</a></center>

        <script>
            function new_cliente() {
                window.open("new_cliente.html", "windowName", "width=500,height=500", false);

            }
        </script>

    </body>
</html>