<%-- 
    Document   : compania_telefono
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CCompania_telefono"%>
<%@page import="com.dbsm.models.catalogo.Compania_telefono"%>
<%@page import="com.dbsm.models.catalogo.Colonia"%>
<%@page import="com.dbsm.controllers.catalogo.CColonia"%>
<%@page import="com.dbsm.controllers.catalogo.CMunicipios"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page import="com.dbsm.models.catalogo.Municipios"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - Compañias</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/compania_telefono.jsp";
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
                <p>compañías de teléfono</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle red"></i>
                Nuevo Compañía
            </h4>
            
            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_compania" id="id_compania">
                
                <div class="field">
                    <label>Compañía*</label>
                    <div class="field" style="width :100%;">
                        <input type="text"  name="compania" id="compania" placeholder="compania" required>
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
                        List<Compania_telefono> companias = CCompania_telefono.getAll();
                        if (companias.size() != 0 && companias.size() > 0) {
                            int k = 0;
                            for (Compania_telefono compania : companias) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + compania.getCOMPANIA() + "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_compania='" + compania.getID_COMPANIA()+ "' "
                                        + "         data-compania='" + compania.getCOMPANIA() + "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_compania='" + compania.getID_COMPANIA() + "' "
                                        + "         data-compania='" + compania.getCOMPANIA() + "' "
                                        + "         title='Eliminar' "
                                        + "        onclick=\"deleteData(this, 'id_compania', '" + urlController + "')\">"
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