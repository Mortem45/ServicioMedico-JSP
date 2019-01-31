<%-- 
    Document   : enfermedad
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CEnfermedad"%>
<%@page import="com.dbsm.models.catalogo.Tipo_enfermedad"%>
<%@page import="com.dbsm.models.catalogo.Enfermedad"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_enfermedad = request.getParameter("id_enfermedad");
    String id_tipo_enfermedad = request.getParameter("id_tipo_enfermedad");
    String enfermedad = request.getParameter("enfermedad");
    String descripcion = request.getParameter("descripcion");
    String solucion = request.getParameter("solucion");
    
    Enfermedad newEnfermedad = new Enfermedad();
    
    
    newEnfermedad.setID_ENFERMEDAD(
        ((id_enfermedad.equals("") || id_enfermedad == null) ? 0 : Integer.valueOf(id_enfermedad))
    );
    newEnfermedad.setTIPO_ENFERMEDAD(new Tipo_enfermedad(
        ((id_tipo_enfermedad.equals("") || id_tipo_enfermedad == null) ? 0 : Integer.valueOf(id_tipo_enfermedad))
    ));
    newEnfermedad.setENFERMEDAD(
        ((enfermedad.equals("") || enfermedad == null) ? "" : enfermedad)
    );
    newEnfermedad.setDESCRIPCION(
        ((descripcion.equals("") || descripcion == null) ? "" : descripcion)
    );
    newEnfermedad.setSOLUCION(
        ((solucion.equals("") || solucion == null) ? "" : solucion)
    );

    if (CEnfermedad.db(newEnfermedad)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>