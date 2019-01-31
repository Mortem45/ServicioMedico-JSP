<%-- 
    Document   : departamento
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.controllers.catalogo.CDepartamento"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_departamento = request.getParameter("id_departamento");
    String id_pais = request.getParameter("id_pais");
    String departamento = request.getParameter("departamento");
    Departamento newDepartamento = new Departamento();
    
    newDepartamento.setID_DEPARTAMENTO(
        ((id_departamento.equals("") || id_departamento == null) ? 0 : Integer.valueOf(id_departamento))
    );
    
    newDepartamento.setPAIS(new Pais(
        ((id_pais.equals("") || id_pais == null) ? 0 : Integer.valueOf(id_pais))
    ));
    
    newDepartamento.setDEPARTAMENTO(
        ((departamento.equals("") || departamento == null) ? "" : departamento)
    );
    
    if (CDepartamento.db(newDepartamento)) {
        status = true;
    }
    
    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
