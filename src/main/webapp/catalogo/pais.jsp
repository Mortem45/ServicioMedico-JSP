<%-- 
    Document   : pais
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.models.catalogo.Pais"%>
<%@page import="java.util.List"%>
<%@page import="com.dbsm.controllers.catalogo.CPais"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - PAIS</title>
        <%out.print(Helpers.head(request.getContextPath()));
            String urlController = request.getContextPath() + "/controllers/catalogo/pais.jsp";
        %>
    </head>
    <body>
        <%out.print(
            Helpers.menu(request.getContextPath())
            + Helpers.navBarTop(request.getContextPath())
        );%>
        
        <div class="content-body">
            <div class="current-section">
                <i class="icon teal thumbtack"></i>
                <p>PAIS</p>
            </div>
            
            <h4 class="ui dividing header">
                <i class="icon plus circle yellow"></i>
                Nuevo País
            </h4>
            <form class="ui form form-aj" id="formSendData">
                <div class="field">
                    <label>Nombre *</label>
                    <div class="one fields">
                        <div class="field">
                            <input type="hidden" name="id_pais" id="id_pais" placeholder="id_pais" >
                        </div>
                        <div class="field" style="width :100%;">
                            <input type="text" name="pais" id="pais" placeholder="Pais" required>
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
                Lista de paises
            </h4>
            <table class="ui blue table selectable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Pais</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
            <%
            List<Pais> paises = CPais.getAll();
            if (paises.size() != 0 && paises.size() > 0) {
                int k = 0;
                for (Pais pais : paises) {
                    out.print(
                        "<tr>"
                        + " <td>" + (k+1) + "</td>"
                        + " <td>" + pais.getPAIS() + "</td>"
                        + " <td>"
                        + "     <button class='ui circular blue icon button'"
                        + "         data-id_pais='" + pais.getID_PAIS() + "' "
                        + "         data-pais='" + pais.getPAIS() + "' "
                        + "         title='Editar' onclick='updateData(this)'>"
                        + "         <i class='pencil alternate icon'></i>"
                        + "     </button>"
                        + "     <button class='ui circular red icon button' "
                        + "         data-id_pais='" + pais.getID_PAIS() + "' "
                        + "         data-pais='" + pais.getPAIS() + "' "
                        + "         title='Eliminar' "
                                + " onclick=\"deleteData(this, 'id_pais', '"+urlController+"')\">"
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
