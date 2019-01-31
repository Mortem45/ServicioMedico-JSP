<%-- 
    Document   : pais
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CPais"%>
<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_pais = request.getParameter("id_pais");
    String pais = request.getParameter("pais");
    Pais newPais = new Pais();
    
    newPais.setID_PAIS(
        ((id_pais.equals("") || id_pais == null) ? 0 : Integer.valueOf(id_pais))
    );
    
    newPais.setPAIS(
        ((pais.equals("") || pais == null) ? "" : pais)
    );
    
    if (CPais.db(newPais)) {
        status = true;
    }
    
    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>