<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	
		<a href="${pageContext.request.contextPath}/atribuir" class="button warning right">Atribuir Representantes</a>
	
		<h2 width="100%" align="center">Representantes</h2>
		<c:forEach var="representante" items="${representantes}">
			<div class="grid-x grid-padding-x registro">
				<div class="cell small-12 text-center">
					<strong>[ ${representante.id} ] ${representante.nome}</strong>
					<br> 
					Localização: ( Latitude: ${representante.latitude} - Longitude: ${representante.longitude} )
				</div>
				<div class="cell small-6 text-center">
					<strong>Lojas no Raio de 2km:</strong><br> 
					<c:forEach var="lojaProxima" items="${representante.lojasProximas}">
						${lojaProxima.loja.nome} (${lojaProxima.distancia})<br>
					</c:forEach>
				</div>
				<div class="cell small-6 text-center">
					<strong>Lojas Atribuidas:</strong> <br>
					<c:forEach var="loja" items="${representante.lojas}">
						${loja.nome}<br>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	
		<h2 width="100%" align="center">Lojas</h2>
		<c:forEach var="loja" items="${lojas}">
			<div class="grid-x grid-padding-x registro">
				<div class="cell small-12 text-center">
					<strong>[ ${loja.id} ] ${loja.nome}</strong>
					<br> 
					Localização: ( Latitude: ${loja.latitude} - Longitude: ${loja.longitude} )
				</div>
				<div class="cell small-6 text-center">
					<strong>Representantes no Raio de 2km:</strong><br> 
					<c:forEach var="representanteProximo" items="${loja.representantesProximos}">
						${representanteProximo.representante.nome} (${representanteProximo.distancia})<br>
					</c:forEach>
				</div>
				<div class="cell small-6 text-center">
					<strong>Representante Responsável:</strong> <br>
						${loja.representante.nome}
				</div>
			</div>
		</c:forEach>
	
<%--
 		<h2 widht="100%" align="center">Representantes</h2>
		<div id="map" style="height: 500px; width: 100%;"></div>
		<div id="labels">${labels}</div>
		<div id="locations">${locations}</div>
 --%>
 	</tiles:putAttribute>
</tiles:insertDefinition>
<script>
      function initMap() {

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 13,
            center: {"lng":-48.520238,"lat":-27.589184}
          });

        // Create an array of alphabetical characters used to label the markers.
        var labels = JSON.parse($('#labels').text());

        // Add some markers to the map.
        // Note: The code uses the JavaScript Array.prototype.map() method to
        // create an array of markers based on a given "locations" array.
        // The map() method here has nothing to do with the Google Maps API.
        var markers = locations.map(function(location, i) {
          return new google.maps.Marker({
            position: location,
            label: labels[i]
          });
        });

        // Add a marker clusterer to manage the markers.
        var markerCluster = new MarkerClusterer(map, markers,
            {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
      }
		var locations = JSON.parse($('#locations').text());    
		
    </script>
    <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
    <!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxkAMBUb7cEpyMK624z6xMNQf6qajwdFU&callback=initMap">
    </script>
