<%-- 
    Document   : enfermedad
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CEnfermedad"%>
<%@page import="com.dbsm.models.catalogo.Enfermedad"%>
<%@page import="com.dbsm.controllers.catalogo.CTipo_enfermedad"%>
<%@page import="com.dbsm.models.catalogo.Tipo_enfermedad"%>
<%@page import="com.dbsm.models.catalogo.Tipo_enfermedad"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - Enfermedad</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/enfermedad.jsp";
        %>
    </head>
    <body>
        <%out.print(
            Helpers.menu(request.getContextPath())
            + Helpers.navBarTop(request.getContextPath())
        );
         List<Tipo_enfermedad> tipos = CTipo_enfermedad.getAll();
        %>

        <div class="content-body">
            <div class="current-section">
                <i class="icon teal thumbtack"></i>
                <p>Enfermedades</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle blue"></i>
                Nueva Enfermedad
            </h4>

            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_enfermedad" id="id_enfermedad">

                <div class="field">
                    <div class="two fields">
                        <label>Tipo Enfermedad*</label>
                        <select class="ui fluid dropdown" name="id_tipo_enfermedad" id="id_tipo_enfermedad" required>
                        <%
                            for (Tipo_enfermedad tipo : tipos) {
                                out.print("<option value='" + tipo.getID_TIPO_ENFERMEDAD() + "'>" + tipo.getTIPO_ENFERMEDAD() + "</option>");
                            }
                        %>
                        </select>
                        <label>Enfermedad*</label>
                        <div class="field" style="width :100%;">
                            <input type="text"  name="enfermedad" id="enfermedad" placeholder="enfermedad" required>
                        </div>
                    </div>
                        
                    <label>Descripci�n *</label>
                    <div class="field" style="width :100%;">
                        <textarea type="text"  name="descripcion" id="descripcion" placeholder="descripcion" required></textarea>
                    </div>
                    
                    <label>Soluci�n *</label>
                    <div class="field" style="width :100%;">
                        <textarea type="text"  name="solucion" id="solucion" placeholder="solucion" required></textarea>
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
                Lista de Enfermedadess
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Tipo</th>
                        <th>Enfermedad</th>
                        <th>Descripci�n</th>
                        <th>Soluci�n</th>
                        <th>Fecha de Registro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody id="body-municipios">
                    <%
                        List<Enfermedad> enfermedades = CEnfermedad.getAll();
                        if (tipos.size() != 0 && tipos.size() > 0) {
                            int k = 0;
                            for (Enfermedad enfermedad : enfermedades) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + enfermedad.getTIPO_ENFERMEDAD().getTIPO_ENFERMEDAD() + "</td>"
                                        + " <td>" + enfermedad.getENFERMEDAD() + "</td>"
                                        + " <td>" + enfermedad.getDESCRIPCION() + "</td>"
                                        + " <td>" + enfermedad.getSOLUCION() + "</td>"
                                        + " <td>" + enfermedad.getFECHA_REGISTRO().toLocaleString() + "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_enfermedad='" + enfermedad.getID_ENFERMEDAD()+ "' "
                                        + "         data-id_tipo_enfermedad='" + enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD()+ "' "
                                        + "         data-enfermedad='" + enfermedad.getENFERMEDAD() + "' "
                                        + "         data-descripcion='" + enfermedad.getDESCRIPCION() + "' "
                                        + "         data-solucion='" + enfermedad.getSOLUCION() + "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_enfermedad='" + enfermedad.getID_ENFERMEDAD() + "' "
                                        + "         data-id_tipo_enfermedad='" + enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() + "' "
                                        + "         data-enfermedad='" + enfermedad.getENFERMEDAD() + "' "
                                        + "         data-descripcion='" + enfermedad.getDESCRIPCION() + "' "
                                        + "         data-solucion='" + enfermedad.getSOLUCION() + "' "
                                        + "         title='Eliminar' "
                                        + "        onclick=\"deleteData(this, 'id_enfermedad', '" + urlController + "')\">"
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
