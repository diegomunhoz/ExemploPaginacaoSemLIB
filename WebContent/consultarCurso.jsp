<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Curso</title>
</head>
<body>
	<f:view>
	  <jsp:include page="/menu.jsp"/>
	  <h:form>
		<h:panelGrid columns="1">
			<h:messages />
		</h:panelGrid>
		
		<h:panelGrid columns="1" width="400">
			<rich:dataTable	id="listaCurso" value="#{cursoBacking.listaCurso}"
			var="curso" width="100%">
			
				<f:facet name="caption">
					<h:outputText value="Lista de Cursos"/>
				</f:facet> 
				
				<f:facet name="header">
				  <rich:columnGroup>
					<rich:column>
						<h:outputText value="Código"/>
					</rich:column>
					<rich:column>
						<h:outputText value="Nome"/>
					</rich:column>
					<rich:column>
						<h:outputText value="Horas"/>
					</rich:column>
				  </rich:columnGroup>
				</f:facet>
				
				<rich:column>
						<h:outputText value="#{curso.codigo}"/>
				</rich:column>
				<rich:column>
						<h:outputText value="#{curso.nome}"/>
				</rich:column>
				<rich:column>
						<h:outputText value="#{curso.horas}"/>
				</rich:column>
			</rich:dataTable>
	 </h:panelGrid>  
	 <h:commandLink action="#{cursoBacking.voltar}">Página Anterior</h:commandLink>
	 <h:commandLink action="#{cursoBacking.avancar}">Próxima Atual</h:commandLink>
	</h:form>
  </f:view>  
 </body>
</html>