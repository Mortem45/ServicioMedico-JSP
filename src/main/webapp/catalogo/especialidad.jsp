<%-- 
    Document   : especialidad
    Author     : grupo 5
--%>

<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.catalogo.CEspecialidad"%>
<%@page import="com.dbsm.models.catalogo.Especialidad"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - EspecialidadesMédicas</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/especialidad.jsp";
        %>
    </head>
    <body>
        <%out.print(
            Helpers.menu(request.getContextPath())
            + Helpers.navBarTop(request.getContextPath())
        );
        %>

        <div class="content-body">
            <div class="current-section">
                <i class="icon teal thumbtack"></i>
                <p>Especialidad Médica</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle red"></i>
                Nueva Especialidad
            </h4>

            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_especialidad" id="id_especialidad">

                <div class="field">
                    <label>Nombre*</label>
                    <div class="field" style="width :100%;">
                        <input type="text"  name="especialidad" id="especialidad" placeholder="especialidad" required>
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
                Lista especialidades médicas
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
                        List<Especialidad> especialidades = CEspecialidad.getAll();
                        if (especialidades.size() != 0 && especialidades.size() > 0) {
                            int k = 0;
                            for (Especialidad especialidad : especialidades) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + especialidad.getESPECIALIDAD()+ "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_especialidad='" + especialidad.getID_ESPECIALIDAD() + "' "
                                        + "         data-especialidad='" + especialidad.getESPECIALIDAD()+ "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_especialidad='" + especialidad.getID_ESPECIALIDAD() + "' "
                                        + "         data-especialidad='" + especialidad.getESPECIALIDAD() + "' "
                                        + "         title='Eliminar' "
                                        + "        onclick=\"deleteData(this, 'id_especialidad', '" + urlController + "')\">"
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

            </script>
        </footer>
    </body>
</html>