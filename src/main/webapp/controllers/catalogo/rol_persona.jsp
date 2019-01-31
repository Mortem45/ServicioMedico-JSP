<%-- 
    Document   : rol_persona
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CRol_persona"%>
<%@page import="com.dbsm.models.catalogo.Rol_persona"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String id_rol = request.getParameter("id_rol");
    String rol = request.getParameter("rol");
    String estado = request.getParameter("estado");
    String user = "";
    Rol_persona newRol = new Rol_persona();
    
    newRol.setID_ROL(
            ((id_rol.equals("") || id_rol == null) ? 0 : Integer.valueOf(id_rol))
    );
    
    newRol.setROL(
            ((rol.equals("") || rol == null) ? "" : rol)
    );
    
    newRol.setESTADO(
            ((estado.equals("") || estado == null) ? "" : estado)
    );
    newRol.setUSUARIO_REGISTRO(
            ((user.equals("") || user == null) ? "" : user)
    );

    if (CRol_persona.db(newRol)) {
        status = true;
    }

    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>