<%-- 
    Document   : municipio
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CMunicipios"%>
<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_municipio = request.getParameter("id_municipio");
    String id_departamento = request.getParameter("id_departamento");
    String id_pais = request.getParameter("id_pais");
    String municipio = request.getParameter("municipio");
    Municipios newMunicipio = new Municipios();
    
    newMunicipio.setID_MUNICIPIO(
        ((id_municipio.equals("") || id_municipio == null) ? 0 : Integer.valueOf(id_municipio))
    );
    
    newMunicipio.setDEPARTAMENTO(new Departamento(
        ((id_departamento.equals("") || id_departamento == null) ? 0 : Integer.valueOf(id_departamento))
    ));

    newMunicipio.setPAIS(new Pais(
            ((id_pais.equals("") || id_pais == null) ? 0 : Integer.valueOf(id_pais))
    ));

    newMunicipio.setMUNICIPIO(
            ((municipio.equals("") || municipio == null) ? "" : municipio)
    );
    
    if (CMunicipios.db(newMunicipio)) {
        status = true;
    }
    
    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
