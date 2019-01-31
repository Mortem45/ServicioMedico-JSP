<%-- 
    Document   : especialidad
    Author     : grupo 5
--%>

<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.controllers.catalogo.CPais"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - Sedes</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/general/sedes.jsp";
            String urlDireccion = request.getContextPath() + "/controllers/catalogo/direccion_selects.jsp";
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
                <p>Sedes</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle orange"></i>
                Nueva Sede
            </h4>
            
            <form class="ui form form-aj" id="formDireccion">
                <input type="hidden" name="id_sede" id="id_sede">
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
                    <div class="two fields">
                        <label>Municipio*</label>
                        <div class="field">
                            <select class="ui fluid dropdown" name="id_municipio" id="id_municipio" required>
                                
                            </select>
                        </div>
                        <label>Colonia*</label>
                        <div class="field">
                            <select class="ui fluid dropdown" name="id_colonia" id="id_colonia" required>

                            </select>
                        </div>
                    </div>
                    <div class="two fields">
                        <label>Calle - Avenida*</label>
                        <div class="field">
                            <input type="text"  name="calle_avenida" id="calle_avenida" placeholder="calle_avenida" required>
                        </div>
                        <label>Numero *</label>
                        <div class="field">
                            <input type="text"  name="numero" id="numero" placeholder="numero" required>
                        </div>
                    </div>
                    <div class="two fields">
                        <label>Edificio*</label>
                        <div class="field">
                            <input type="text"  name="edificio" id="edificio" placeholder="edificio" required>
                        </div>
                    </div>
                </div>
            </form>
            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_sede" id="id_sede">

                <div class="field">
                    <label>Nombre*</label>
                    <div class="field" style="width :100%;">
                        <input type="text"  name="nombre" id="nombre" placeholder="nombre" required>
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
                Listado de sedes
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Especialidad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody id="body-municipios">
                    <%
//                        List<Especialidad> especialidades = CEspecialidad.getAll();
//                        if (especialidades.size() != 0 && especialidades.size() > 0) {
//                            int k = 0;
//                            for (Especialidad especialidad : especialidades) {
//                                out.print(
//                                        "<tr>"
//                                        + " <td>" + (k + 1) + "</td>"
//                                        + " <td>" + especialidad.getESPECIALIDAD()+ "</td>"
//                                        + " <td>"
//                                        + "     <button class='ui circular blue icon button'"
//                                        + "         data-id_especialidad='" + especialidad.getID_ESPECIALIDAD() + "' "
//                                        + "         data-especialidad='" + especialidad.getESPECIALIDAD()+ "' "
//                                        + "         title='Editar' onclick='updateData(this)'>"
//                                        + "         <i class='pencil alternate icon'></i>"
//                                        + "     </button>"
//                                        + "     <button class='ui circular red icon button' "
//                                        + "         data-id_especialidad='" + especialidad.getID_ESPECIALIDAD() + "' "
//                                        + "         data-especialidad='" + especialidad.getESPECIALIDAD() + "' "
//                                        + "         title='Eliminar' "
//                                        + "        onclick=\"deleteData(this, 'id_especialidad', '" + urlController + "')\">"
//                                        + "         <i class='trash alternate icon'></i>"
//                                        + "     </button>"
//                                        + " </td>"
//                                        + "</tr>"
//                                );
//                                k++;
//                            }
//                        } else {
//                            out.print("<tr><td>NO HAY CONTENIDO !</td></tr>");
//                        }
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
                
                selects_direccion("#formDireccion", "<%out.print(urlDireccion);%>");

            </script>
        </footer>
    </body>
</html>