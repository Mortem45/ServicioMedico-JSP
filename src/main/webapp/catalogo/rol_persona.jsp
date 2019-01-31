<%-- 
    Document   : rol_persona
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CRol_persona"%>
<%@page import="com.dbsm.models.catalogo.Rol_persona"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - Enfermedad</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/rol_persona.jsp";
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
                <p>Roles de Personas</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle blue"></i>
                Nuevo Rol
            </h4>

            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_rol" id="id_rol">

                <div class="field">
                    <label>Rol*</label>
                    <div class="field">
                        <input type="text"  name="rol" id="rol" placeholder="rol" required>
                    </div>
                </div>
                <div class="field">
                    <label>Estado*</label>
                    <select class="ui fluid dropdown" name="estado" id="estado" required>
                        <option value="INACTIVO">INACTIVO</option>
                        <option value="ACTIVO">ACTIVO</option>
                    </select>
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
                Lista de Roles
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Rol</th>
                        <th>Estado</th>
                        <th>Registrado por</th>
                        <th>Fecha registro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody id="body-municipios">
                    <%
                        List<Rol_persona> roles = CRol_persona.getAll();
                        if (roles.size() != 0 && roles.size() > 0) {
                            int k = 0;
                            for (Rol_persona rol : roles) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + rol.getROL() + "</td>"
                                        + " <td>" + rol.getESTADO() + "</td>"
                                        + " <td>" + rol.getUSUARIO_REGISTRO() + "</td>"
                                        + " <td>" + rol.getFECHA_REGISTRO().toLocaleString() + "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_rol='" + rol.getID_ROL() + "' "
                                        + "         data-rol='" + rol.getROL() + "' "
                                        + "         data-estado='" + rol.getESTADO() + "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_rol='" + rol.getID_ROL() + "' "
                                        + "         data-rol='" + rol.getROL() + "' "
                                        + "         data-estado='" + rol.getESTADO() + "' "
                                        + "         title='Eliminar' "
                                        + "        onclick=\"deleteData(this, 'id_rol', '" + urlController + "')\">"
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
