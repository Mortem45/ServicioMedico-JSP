<%-- 
    Document   : tipo_sangre
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CTipo_sangre"%>
<%@page import="com.dbsm.models.catalogo.Tipo_sangre"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_tipo_sangre = request.getParameter("id_tipo_sangre");
    String tipo_sangre = request.getParameter("tipo_sangre");
    Tipo_sangre newTipo = new Tipo_sangre();

    newTipo.setID_TIPO_SANGRE(
        ((id_tipo_sangre.equals("") || id_tipo_sangre == null) ? 0 : Integer.valueOf(id_tipo_sangre))
    );
    newTipo.setTIPO_SANGRE(
        ((tipo_sangre.equals("") || tipo_sangre == null) ? "" : tipo_sangre)
    );

    if (CTipo_sangre.db(newTipo)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
