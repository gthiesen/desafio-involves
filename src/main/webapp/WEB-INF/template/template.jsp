<%@page import="com.involves.desafio.service.InitService"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Desafio Involves</title>

<link rel="icon" href="${pageContext.request.contextPath}/resources/imagens/empresa_logo.png" sizes="16x16">

<!-- If you are using the CSS version, only link these 2 files, you may add app.css to use for your overrides if you like -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/foundation-6.5.1-complete/css/foundation.min.css?versao=<%=InitService.VERSAO%>" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css?versao=<%=InitService.VERSAO%>" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-2.1.4.min.js?versao=<%=InitService.VERSAO%>"></script>
<script src="${pageContext.request.contextPath}/resources/foundation-6.5.1-complete/js/vendor/foundation.min.js?versao=<%=InitService.VERSAO%>"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js?versao=<%=InitService.VERSAO%>"></script>


</head>
<body>
	<div class="page">
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<br>
		<div class="body">
			<tiles:insertAttribute name="body" />
		</div>
		<br>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
<script>$(document).foundation()</script>