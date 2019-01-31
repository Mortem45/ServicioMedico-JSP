<%-- 
    Document   : compania_telefono
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CCompania_telefono"%>
<%@page import="com.dbsm.models.catalogo.Compania_telefono"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_compania = request.getParameter("id_compania");
    String compania = request.getParameter("compania");
    Compania_telefono newCompania = new Compania_telefono();
    
    newCompania.setID_COMPANIA(
            ((id_compania.equals("") || id_compania == null) ? 0 : Integer.valueOf(id_compania))
    );
    newCompania.setCOMPANIA(
            ((compania.equals("") || compania == null) ? "" : compania)
    );

    if (CCompania_telefono.db(newCompania)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>