<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		
		<div class="large-12 columns titlesecao">
			Representante <strong>${grupo.id}</strong>
		</div>
		<div class="large-12 columns secao">
		<form:form  action="${pageContext.request.contextPath}/representante/save" method="POST" modelAttribute="representante">
			<form:hidden path="id"/>
			<div class="grid-container">
				<div class="grid-x">
					<div class="large-8 cell">
						Nome
						<form:input path="nome" />
						<form:errors path="nome" cssClass="error" element="small"/>
					</div>
					<div class="large-2 cell">
						Latitude
						<form:input path="latitude" />
						<form:errors path="latitude" cssClass="error" element="small"/>
					</div>
					<div class="large-2 cell">
						Longitude
						<form:input path="longitude" />
						<form:errors path="longitude" cssClass="error" element="small"/>
					</div>
				</div>
				<div class="cell large-12">
					Lojas
					<c:forEach items="${representante.lojas}" var="loja">
						<div class="row"><div class="columns large-12">${loja.nome}</div></div>	
					</c:forEach>
				</div>
				<div class="cell large-12 text-center">
					<a href="${pageContext.request.contextPath}/representante/list" class="button tiny secondary">Cancelar</a>
					<form:button class="button tiny" value="Salvar">Salvar</form:button>
				</div>
			</div>
		</form:form>
		</fieldset>
	</tiles:putAttribute>
</tiles:insertDefinition>
