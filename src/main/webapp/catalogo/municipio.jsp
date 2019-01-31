<%-- 
    Document   : municipio
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CMunicipios"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page import="com.dbsm.controllers.catalogo.CPais"%>
<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.controllers.catalogo.CDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - MUNICIPIOS</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/municipio.jsp";
            String urlDireccion_selects = request.getContextPath() + "/controllers/catalogo/direccion_selects.jsp";
        %>
    </head>
    <body>
        <%out.print(
                    Helpers.menu(request.getContextPath())
                    + Helpers.navBarTop(request.getContextPath())
            );
           List<Pais> paises = CPais.getAll();
        %>

        <div class="content-body">
            <div class="current-section">
                <i class="icon teal thumbtack"></i>
                <p>Municipio</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle red"></i>
                Nuevo Municipio
            </h4>

            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_municipio" id="id_municipio">
                <div class="field">
                    <div class="two fields">
                        <label>Pais*</label>
                        <div class="field">
                            <select class="ui fluid dropdown" name="id_pais" id="id_pais" required>
                                <%
                                for (Pais pais : paises) {
                                    out.print("<option value='" + pais.getID_PAIS() + "'>" + pais.getPAIS() + "</option>");
                                }
                                %>
                            </select>
                        </div>
                        <label>Departamento*</label>
                        <div class="field">
                            <select class="ui fluid dropdown" name="id_departamento" id="id_departamento" required>
                                
                            </select>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <label>Nombre*</label>
                    <div class="field" style="width :100%;">
                        <input type="text" name="municipio" id="municipio" placeholder="Municipio" required>
                    </div>
                </div>
                            
                <div class="segment-buttons" style="width: 100%; text-align: center;">
                    <div class="ui buttons " style="background-color: #fff;">
                        <button class="ui inverted violet button" id="btnCalcelData">
                            <i class="icon times circle outline"></i>
                            Cancelar
                        </button>
                        <div class="or or-button"></div>
                        <button class="ui inverted primary button" id="btnSendData">
                            <i class="icon save outline"></i>
                            Guardar
                        </button>
                    </div>
                </div>
            </form>

            <h4 class="ui dividing header">
                <i class="icon ellipsis vertical blue"></i>
                Lista de municipios
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Departamento</th>
                        <th>Municipio</th>
                        <th>Fecha de registro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody id="body-municipios">
                    <%
                        List<Municipios> municipios = CMunicipios.getAll();
                        if (municipios.size() != 0 && municipios.size() > 0) {
                            int k = 0;
                            for (Municipios municipio : municipios) {
                                out.print(
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
                                    + "        onclick=\"deleteData(this, 'id_municipio', '" + urlController + "')\">"
                                    + "         <i class='trash alternate icon'></i>"
                                    + "     </button>"
                                    + " </td>"
                                    + "</tr>"
                                );
                                k++;
                           }
                        } else {
                            out.print("<tr><td>NO HAY CONTENIDO !</td></tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>

        <%out.print(Helpers.footerPage());%>    
        <footer>
            <%
                out.print(Helpers.footerScript(request.getContextPath()));
            %>
            <script>
                /*Enviar datos*/
                sendData("<%out.print(urlController);%>", "#formSendData", "#btnSendData");
                
                //clear form calcel data
                cancelData("#formSendData", "#btnCalcelData");
                
                //Cargar los departamentos del pais por defecto
                departamentos();
                
                //Carga de los municipios
                $("#id_departamento").change(function(e) {
                    allMunicipiosByDepartamento();
                });
                
                function departamentos() {
                   let idpais = $("#id_pais").val();
                   if (idpais != "" && idpais != null) {
                        $("#screenMessage #legend").text("SELECT...");
                        $("#screenMessage").fadeIn();
                        $.ajax({
                            method: "POST",
                            url: "<%out.print(urlDireccion_selects);%>",
                            data: {"type" : "departamento", "id" : idpais},
                        }).always(function (e) {
                            $("#id_departamento").html(e);
                            $("#screenMessage").fadeOut(function () {});
                        });
                   }
                }
                
                function allMunicipiosByDepartamento() {
                    let idDepartamento = $("#id_departamento").val();
                    
                    if (idDepartamento != "" && idDepartamento != null) {
                        $("#screenMessage #legend").text("FILTRANDO...");
                        $("#screenMessage").fadeIn();
                        $.ajax({
                            method: "POST",
                            url: "<%out.print(urlDireccion_selects);%>",
                            data: {
                                "type" : "data_municipios", 
                                "id" : idDepartamento,
                                "urlcontroller" : "<%out.print(urlController);%>"
                            },
                        }).always(function (e) {
                            $("#body-municipios").html(e);
                            $("#screenMessage").fadeOut(function () {});
                        });
                    }
                }
                
            </script>
        </footer>
    </body>
</html>
