<%-- 
    Document   : direccion
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CColonia"%>
<%@page import="com.dbsm.models.catalogo.Colonia"%>
<%@page import="com.dbsm.controllers.catalogo.CMunicipios"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page import="com.dbsm.controllers.catalogo.CDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page contentType="text/html; UTF-8"%>
<%
    boolean status = false;
    String type = request.getParameter("type");
    String id  = request.getParameter("id");
    String urlcontroller  = request.getParameter("urlcontroller");
   
    if (!type.equals("") && type != null
        && !id.equals("") && id != null) {
        String options = "";
        if (type.equals("departamento")) {
            List<Departamento> departamentos = CDepartamento.getDepartamentosByPais(Integer.valueOf(id));
            for (Departamento departamento : departamentos) {
                options += "<option value='" + departamento.getID_DEPARTAMENTO() + "'>" + departamento.getDEPARTAMENTO() + "</option>";
            }
            status = true;
        }
        
        if (type.equals("municipio")) {
            List<Municipios> municipios = CMunicipios.getMunicipiosByDepartamento(Integer.valueOf(id));
            for (Municipios municipio : municipios) {
                options += "<option value='" + municipio.getID_MUNICIPIO() + "'>" + municipio.getMUNICIPIO() + "</option>";
            }
            status = true;
        }
        if (type.equals("colonia")) {
            List<Colonia> colonias = CColonia.getAllByMunicipio(Integer.valueOf(id));
            for (Colonia colonia : colonias) {
                options += "<option value='" + colonia.getID_COLONIA() + "'>" + colonia.getCOLONIA() + "</option>";
            }
            status = true;
        }
        if (type.equals("data_municipios")) {
            List<Municipios> municipios = CMunicipios.getMunicipiosByDepartamento(Integer.valueOf(id));
            int k = 0;
                for (Municipios municipio : municipios) {
                    options +=
                            "<tr>"
                            + " <td>" + (k + 1) + "</td>"
                            + " <td>" + municipio.getDEPARTAMENTO().getDEPARTAMENTO() + "</td>"
                            + " <td>" + municipio.getMUNICIPIO() + "</td>"
                            + " <td>" + municipio.getFECHA_REGISTRO().toLocaleString() + "</td>"
                            + " <td>"
                            + "     <button class='ui circular blue icon button'"
                            + "         data-id_municipio='" + municipio.getID_MUNICIPIO() + "' "
                            + "         data-id_departamento='" + municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() + "' "
                            + "         data-id_pais='" + municipio.getPAIS().getID_PAIS() + "' "
                            + "         data-municipio='" + municipio.getMUNICIPIO() + "' "
                            + "         title='Editar' onclick='updateData(this)'>"
                            + "         <i class='pencil alternate icon'></i>"
                            + "     </button>"
                            + "     <button class='ui circular red icon button' "
                            + "         data-id_municipio='" + municipio.getID_MUNICIPIO() + "' "
                            + "         data-id_departamento='" + municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() + "' "
                            + "         data-id_pais='" + municipio.getPAIS().getID_PAIS() + "' "
                            + "         data-municipio='" + municipio.getMUNICIPIO() + "' "
                            + "         title='Eliminar' "
                            + "        onclick=\"deleteData(this, 'id_municipio', '" + urlcontroller + "')\">"
                            + "         <i class='trash alternate icon'></i>"
                            + "     </button>"
                            + " </td>"
                            + "</tr>";
                    k++;
                }
            status = true;
        }
        out.print(options);
    }
    
    if (status) {
        response.setStatus(200);
    } else {
        response.setStatus(401);
    }
%>