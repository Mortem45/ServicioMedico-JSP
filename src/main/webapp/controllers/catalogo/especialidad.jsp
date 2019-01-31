<%-- 
    Document   : especialidad
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CEspecialidad"%>
<%@page import="com.dbsm.models.catalogo.Especialidad"%>
<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.controllers.catalogo.CDepartamento"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_especialidad = request.getParameter("id_especialidad");
    String especialidad = request.getParameter("especialidad");
    Especialidad newEspecialidad = new Especialidad();
    
    newEspecialidad.setID_ESPECIALIDAD(
        ((id_especialidad.equals("") || id_especialidad == null) ? 0 : Integer.valueOf(id_especialidad))
    );
    newEspecialidad.setESPECIALIDAD(
        ((especialidad.equals("") || especialidad == null) ? "" : especialidad)
    );
    
    if (CEspecialidad.db(newEspecialidad)) {
        status = true;
    }
    
    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
