<%-- 
    Document   : zonas
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CZonas"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page import="com.dbsm.models.catalogo.Zonas"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_zona = request.getParameter("id_zona");
    String id_municipio = request.getParameter("id_municipio");
    String zona = request.getParameter("zona");
    Zonas newZona = new Zonas();
    
    newZona.setID_ZONA(
        ((id_zona.equals("") || id_zona == null) ? 0 : Integer.valueOf(id_zona))
    );
    newZona.setMUNICIPIO( new Municipios(
        ((id_municipio.equals("") || id_municipio == null) ? 0 : Integer.valueOf(id_municipio))
    ));
    newZona.setZONA(
        ((zona.equals("") || zona == null) ? 0 : Integer.valueOf(zona))
    );

    if (CZonas.db(newZona)) {
        status = true;
    }
    
    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
