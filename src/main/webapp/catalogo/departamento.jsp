<%-- 
    Document   : departamento
    Author     : grupo 5
--%>

<%@page import="com.dbsm.controllers.catalogo.CPais"%>
<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="com.dbsm.controllers.catalogo.CDepartamento"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page import="com.dbsm.models.catalogo.Departamento"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - PAIS</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/departamento.jsp";
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
                <p>Departamento</p>
            </div>

            <h4 class="ui dividing header">
                <i class="icon plus circle red"></i>
                Nuevo Departamento
            </h4>
            
            <form class="ui form form-aj" id="formSendData">
                <input type="hidden" name="id_departamento" id="id_departamento">
                <div class="field">
                    <div class="two fields">
                        <label>Pais*</label>
                        <div class="field">
                            <select class="ui fluid dropdown" name="id_pais" id="id_pais" required>
                                <%
                                for (Pais pais : paises) {
                                    out.print(
                                        "<option value='" + pais.getID_PAIS() + "'>" + pais.getPAIS() + "</option>"
                                    );
                                }
                                %>
                            </select>
                        </div>
                        <label>Nombre*</label>
                        <div class="field" style="width :100%;">
                            <input type="text" name="departamento" id="departamento" placeholder="Nombre" required>
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
                Lista de Departamentos
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Pais</th>
                        <th>Departamento</th>
                        <th>Fecha de registro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Departamento> departamentos = CDepartamento.getAll();
                        if (departamentos.size() != 0 && departamentos.size() > 0) {
                            int k = 0;
                            for (Departamento departamento : departamentos) {
                                out.print(
                                        "<tr>"
                                        + " <td>" + (k + 1) + "</td>"
                                        + " <td>" + departamento.getPAIS().getPAIS() + "</td>"
                                        + " <td>" + departamento.getDEPARTAMENTO() + "</td>"
                                        + " <td>" + departamento.getFECHA_REGISTRO().toLocaleString() + "</td>"
                                        + " <td>"
                                        + "     <button class='ui circular blue icon button'"
                                        + "         data-id_departamento='" + departamento.getID_DEPARTAMENTO() + "' "
                                        + "         data-id_pais='" + departamento.getPAIS().getID_PAIS() + "' "
                                        + "         data-pais='" + departamento.getPAIS().getPAIS() + "' "
                                        + "         data-departamento='" + departamento.getDEPARTAMENTO() + "' "
                                        + "         title='Editar' onclick='updateData(this)'>"
                                        + "         <i class='pencil alternate icon'></i>"
                                        + "     </button>"
                                        + "     <button class='ui circular red icon button' "
                                        + "         data-id_departamento='" + departamento.getID_DEPARTAMENTO() + "' "
                                        + "         data-id_pais='" + departamento.getPAIS().getID_PAIS() + "' "
                                        + "         data-pais='" + departamento.getPAIS().getPAIS() + "' "
                                        + "         data-departamento='" + departamento.getDEPARTAMENTO() + "' "
                                        + "         title='Eliminar' "
                                        + " onclick=\"deleteData(this, 'id_departamento', '" + urlController + "')\">"
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
