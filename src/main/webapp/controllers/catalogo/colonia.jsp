<%-- 
    Document   : colonia
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CColonia"%>
<%@page import="com.dbsm.models.catalogo.Colonia"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_colonia = request.getParameter("id_colonia");
    String id_municipio = request.getParameter("id_municipio");
    String colonia = request.getParameter("colonia");
    Colonia newColonia = new Colonia();
    
    newColonia.setID_COLONIA(
            ((id_colonia.equals("") || id_colonia == null) ? 0 : Integer.valueOf(id_colonia))
    );
    newColonia.setMUNICIPIO(new Municipios(
            ((id_municipio.equals("") || id_municipio == null) ? 0 : Integer.valueOf(id_municipio))
    ));
    newColonia.setCOLONIA(
            ((colonia.equals("") || colonia == null) ? "" : colonia)
    );

    if (CColonia.db(newColonia)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>
