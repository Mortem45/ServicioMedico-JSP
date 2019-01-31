<%-- 
    Document   : tipo_telefono
    Author     : grupo 5
--%>

<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.catalogo.CTipo_telefono"%>
<%@page import="com.dbsm.models.catalogo.Tipo_telefono"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - TiposTelefono</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/tipo_telefono.jsp";
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
                <p>tipo de teléfono</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle red"></i>
                Nuevo Tipo
            </h4>

            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_tipo_telefono" id="id_tipo_telefono">

                <div class="field">
                    <label>Tipo Teléfono*</label>
                    <div class="field" style="width :100%;">
                        <input type="text"  name="tipo_telefono" id="tipo_telefono" placeholder="tipo_telefono" required>
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
                Lista de Compañias
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Compañia</th>
                    </tr>
                </thead>
                <tbody id="body-municipios">
                    <%
                        List<Tipo_telefono> tipos = CTipo_telefono.getAll();
                        if (tipos.size() != 0 && tipos.size() > 0) {
                            int k = 0;
                            for (Tipo_telefono tipo : tipos) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + tipo.getTIPO_TELEFONO() + "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_tipo_telefono='" + tipo.getID_TIPO_TELEFONO() + "' "
                                        + "         data-tipo_telefono='" + tipo.getTIPO_TELEFONO() + "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_tipo_telefono='" + tipo.getID_TIPO_TELEFONO() + "' "
                                        + "         data-tipo_telefono='" + tipo.getTIPO_TELEFONO() + "' "
                                        + "         title='Eliminar' "
                                        + "        onclick=\"deleteData(this, 'id_tipo_telefono', '" + urlController + "')\">"
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
