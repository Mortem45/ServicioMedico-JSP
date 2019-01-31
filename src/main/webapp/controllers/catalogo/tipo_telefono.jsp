<%-- 
    Document   : tipo_telefono
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CTipo_telefono"%>
<%@page import="com.dbsm.models.catalogo.Tipo_telefono"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_tipo_telefono = request.getParameter("id_tipo_telefono");
    String tipo_telefono = request.getParameter("tipo_telefono");
    Tipo_telefono newTipo = new Tipo_telefono();

    newTipo.setID_TIPO_TELEFONO(
            ((id_tipo_telefono.equals("") || id_tipo_telefono == null) ? 0 : Integer.valueOf(id_tipo_telefono))
    );
    newTipo.setTIPO_TELEFONO(
            ((tipo_telefono.equals("") || tipo_telefono == null) ? "" : tipo_telefono)
    );

    if (CTipo_telefono.db(newTipo)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
