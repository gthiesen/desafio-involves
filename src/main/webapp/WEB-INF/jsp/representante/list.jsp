<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<c:choose>
			<c:when test="${not empty representantes}">
				<c:forEach var="representante" items="${representantes}">
					<div class="row registro">
					<div class="columns large-8">
						<div>
							<strong>[ ${representante.id} ] ${representante.nome}</strong>
							<br> 
							Localização: ( Latitude: ${representante.latitude} - Longitude: ${representante.longitude}
							<br>
							Lojas: ${representante.lojas}
						</div>
					</div>
					<div class="columns large-4" style="text-align: right">
						<a class="button icon fa fa-edit radius localEdit radius"
							href="${pageContext.request.contextPath}/representante/edit/${representante.id}"  title="Editar"></a>
					</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="panel" style="margin-top: 10px;">
				Nenhuma Representante encontrada.
				</div>
			</c:otherwise>
		</c:choose>
		
		
	</tiles:putAttribute>
</tiles:insertDefinition>
