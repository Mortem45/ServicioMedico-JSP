<%-- 
    Document   : index
    Author     : Grupo 5
--%>

<%@page import="com.dbsm.controllers.Helpers"%>
<%@page import="com.dbsm.controllers.Constants"%>
<%@page contentType="text/html UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%out.print(Constants.nameProjectInitials);%> - CATALOGOS</title>
        <%out.print(Helpers.head(request.getContextPath()));%>
    </head>
    <body>
        <%out.print(
            Helpers.menu(request.getContextPath())
            + Helpers.navBarTop(request.getContextPath())
        );%>
        
        <div class="content-body">
            <div class="current-section">
                <i class="icon teal thumbtack"></i>
                <p>CATALOGOS</p>
            </div>
            
            <h4 class="ui horizontal divider header">
                <i class="icon map signs teal"></i>
                Dirección
            </h4>
            <div class="ui three cards">
                <a class="ui yellow card orange" href="<%=request.getContextPath()%>/catalogo/pais.jsp">
                    <div class="content">
                        <div class="header">Pais</div>
                        <div class="meta">
                            <span class="category">Registro, consulta y edición de Paises</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon yellow icon globe"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <span class="category">Configurado por defecto solo Guatemala</span>
                        <div class="right floated author">
                            <i class="icon map signs teal"></i> Dirección
                        </div>
                    </div>
                </a>
                
                <a class="ui link card red" href="<%=request.getContextPath()%>/catalogo/departamento.jsp">
                    <div class="content">
                        <div class="header">Departamento</div>
                        <div class="meta">
                            <span class="category">Registro, consulta y edición de departamentos</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon red icon map marker alternate"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon map signs teal"></i> Dirección
                        </div>
                    </div>
                </a>
                
                <a class="ui link card orange" href="<%=request.getContextPath()%>/catalogo/municipio.jsp">
                    <div class="content">
                        <div class="header">Municipio</div>
                        <div class="meta">
                            <span class="category">Registro, consulta y edición de municipios</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon orange icon map marker"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon map signs teal"></i> Dirección
                        </div>
                    </div>
                </a>
                
                <a class="ui olive card orange" href="<%=request.getContextPath()%>/catalogo/zonas.jsp">
                    <div class="content">
                        <div class="header">Zonas</div>
                        <div class="meta">
                            <span class="category">Catálogo de zonas</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon olive icon map"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon map signs teal"></i> Dirección
                        </div>
                    </div>
                </a>
                
                <a class="ui green card orange" href="<%=request.getContextPath()%>/catalogo/colonia.jsp">
                    <div class="content">
                        <div class="header">Colonias</div>
                        <div class="meta">
                            <span class="category">Catálogo de Colonias</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon green icon map signs"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon map signs teal"></i> Dirección
                        </div>
                    </div>
                </a>
            </div>
            <h4 class="ui horizontal divider header">
                <i class="icon phone orange"></i>
                Teléfono
            </h4>
            <div class="ui three cards">
                <a class="ui violet card orange" href="<%=request.getContextPath()%>/catalogo/compania_telefono.jsp">
                    <div class="content">
                        <div class="header">Compañía</div>
                        <div class="meta">
                            <span class="category">Telefonias del país</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon violet icon tty"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon phone orange"></i> Teléfono
                        </div>
                    </div>
                </a>
                <a class="ui yellow card orange" href="<%=request.getContextPath()%>/catalogo/tipo_telefono.jsp">
                    <div class="content">
                        <div class="header">Tipos de Teléfono</div>
                        <div class="meta">
                            <span class="category">Registro de tipos de telefonos</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon yellow icon mobile alternate"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon phone orange"></i> Teléfono
                        </div>
                    </div>
                </a>
            </div>
            <h4 class="ui horizontal divider header">
                <i class="icon hospital symbol pink"></i>
                Datos Hospitalarios
            </h4>
            <div class="ui three cards">
                <a class="ui purple card orange" href="<%=request.getContextPath()%>/catalogo/tipo_sangre.jsp">
                    <div class="content">
                        <div class="header">Tipo de Sangre</div>
                        <div class="meta">
                            <span class="category">Registro de todos los tipos de sangre</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon purple icon syringe"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon hospital symbol pink"></i> Datos Hospitalarios
                        </div>
                    </div>
                </a>
                <a class="ui teal card orange" href="<%=request.getContextPath()%>/catalogo/tipo_enfermedad.jsp">
                    <div class="content">
                        <div class="header">Tipo de Enfermedades</div>
                        <div class="meta">
                            <span class="category">Registro de todos los tipos de enfermedades</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon teal icon dna"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                           <i class="icon hospital symbol pink"></i> Datos Hospitalarios
                        </div>
                    </div>
                </a>
                <a class="ui red card orange" href="<%=request.getContextPath()%>/catalogo/enfermedad.jsp">
                    <div class="content">
                        <div class="header">Enfermedades</div>
                        <div class="meta">
                            <span class="category">Registro de todos las enfermedades</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon red icon heartbeat"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon hospital symbol pink"></i> Datos Hospitalarios
                        </div>
                    </div>
                </a>
            </div>
            <h4 class="ui horizontal divider header">
                <i class="icon olive  shield alternate"></i>
                Especialidades de Médicos
            </h4>
            <div class="ui three cards">
                <a class="ui black card blue" href="<%=request.getContextPath()%>/catalogo/especialidad.jsp">
                    <div class="content">
                        <div class="header">Especialidades de Médicos del Hospital</div>
                        <div class="meta">
                            <span class="category">Registro de todos las especialidades de los médicos del hospital</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon blue icon stethoscope"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon blue shield alternate"></i> Roles
                        </div>
                    </div>
                </a>
            </div>
            <h4 class="ui horizontal divider header">
                <i class="icon olive  shield alternate"></i>
                Roles
            </h4>
            <div class="ui three cards">
                <a class="ui black card orange" href="<%=request.getContextPath()%>/catalogo/rol_persona.jsp">
                    <div class="content">
                        <div class="header">Roles de Centro Médico</div>
                        <div class="meta">
                            <span class="category">Registro de todos los tipos de roles del centro médico</span>
                        </div>
                        <div class="description" style="text-align: center;">
                            <i class="big-icon black icon user secret"></i>
                        </div>
                    </div>
                    <div class="extra content">
                        <div class="right floated author">
                            <i class="icon olive shield alternate"></i> Roles
                        </div>
                    </div>
                </a>
            </div>
        </div>    
        <%out.print(Helpers.footerPage());%>    
        <footer>
            <%
                out.print(Helpers.footerScript(request.getContextPath()));
            %>
        </footer>
    </body>
</html>
