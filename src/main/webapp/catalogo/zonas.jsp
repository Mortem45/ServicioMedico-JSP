<%-- 
    Document   : zonas
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CZonas"%>
<%@page import="com.dbsm.models.catalogo.Zonas"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.catalogo.CMunicipios"%>
<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - Zonas</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/zonas.jsp";
        %>
    </head>
    <body>
        <%out.print(
                    Helpers.menu(request.getContextPath())
                    + Helpers.navBarTop(request.getContextPath())
            );
            List<Municipios> municipios = CMunicipios.getAll();
        %>

        <div class="content-body">
            <div class="current-section">
                <i class="icon teal thumbtack"></i>
                <p>Zonas</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle red"></i>
                Nuevo Zona
            </h4>
            
            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_zona" id="id_zona">
                
                <div class="field">
                    <div class="two fields">
                        <label>Municipio*</label>
                        <select class="ui fluid dropdown" name="id_municipio" id="id_municipio" required>
                            <%
                                for (Municipios municipio : municipios) {
                                    out.print(
                                        "<option value=" + municipio.getID_MUNICIPIO() + ">" 
                                        + municipio.getMUNICIPIO() + "</option>"
                                    );
                                }
                            %>
                        </select>
                        <label>Zona*</label>
                        <div class="field" style="width :100%;">
                            <input type="number" step="1" min="1" name="zona" id="zona" placeholder="zona" required>
                        </div>
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
                Lista de Zonas
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Municipio</th>
                        <th>Zona</th>
                        <th>Fecha de registro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody id="body-municipios">
                    <%
                        List<Zonas> zonas = CZonas.getAll();
                        if (zonas.size() != 0 && zonas.size() > 0) {
                            int k = 0;
                            for (Zonas zona : zonas) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + zona.getMUNICIPIO().getMUNICIPIO() + "</td>"
                                        + " <td>" + zona.getZONA() + "</td>"
                                        + " <td>" + zona.getFECHA_REGISTRO().toLocaleString() + "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_zona='" + zona.getID_ZONA() + "' "
                                        + "         data-id_municipio='" + zona.getMUNICIPIO().getID_MUNICIPIO() + "' "
                                        + "         data-zona='" + zona.getZONA() + "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_zona='" + zona.getID_ZONA() + "' "
                                        + "         data-id_municipio='" + zona.getMUNICIPIO().getID_MUNICIPIO() + "' "
                                        + "         data-zona='" + zona.getZONA() + "' "
                                        + "         title='Eliminar' "
                                        + "        onclick=\"deleteData(this, 'id_zona', '" + urlController + "')\">"
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