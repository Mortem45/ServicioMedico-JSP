<%-- 
    Document   : tipo_enfermedad
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CTipo_enfermedad"%>
<%@page import="com.dbsm.models.catalogo.Tipo_enfermedad"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_tipo_enfermedad = request.getParameter("id_tipo_enfermedad");
    String tipo_enfermedad = request.getParameter("tipo_enfermedad");
    
    Tipo_enfermedad newTipo = new Tipo_enfermedad();

    newTipo.setID_TIPO_ENFERMEDAD(
        ((id_tipo_enfermedad.equals("") || id_tipo_enfermedad == null) ? 0 : Integer.valueOf(id_tipo_enfermedad))
    );
    newTipo.setTIPO_ENFERMEDAD(
        ((tipo_enfermedad.equals("") || tipo_enfermedad == null) ? "" : tipo_enfermedad)
    );

    if (CTipo_enfermedad.db(newTipo)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
