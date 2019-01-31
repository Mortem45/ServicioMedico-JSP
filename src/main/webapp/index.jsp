<%@page import="com.dbsm.controllers.Constants"%>
<%@page import="com.dbsm.controllers.Helpers"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProject);%></title>
        <%out.print(Helpers.head(request.getContextPath()));%>
    </head>
    <body>
        <%out.print(
            Helpers.menu(request.getContextPath()) +
            Helpers.navBarTop(request.getContextPath())
        );%>
        
        <div class="content-body">
            
        </div>
        
        <%out.print(Helpers.footerPage());%>    
        <footer>
            <%
                out.print(Helpers.footerScript(request.getContextPath()));
            %>
        </footer>
    </body>
</html>
