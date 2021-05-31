
google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawReport);

function drawReport() {
    
	var result = $.ajax({
		url : "/inmueble/byCiudadEstado",
		method : "POST",
		contentType : "application/json",
		dataType : "json",
	    async: true}).responseText;

	
	var jsonData = JSON.parse(result);
	var report = [];
	
	$.each(jsonData, function(i, ciu) {
		report.push([ciu.ciudad,ciu.Disponibles,ciu.noDisponibles]);
	});
	
	var data = new google.visualization.DataTable();
	data.addColumn('string', 'ciudad');
    data.addColumn('number', 'Disponibles');
    data.addColumn('number', 'noDisponibles');
    data.addRows(report);
    
    var options = {
            title: 'Arrendamientos por Ciudad y Estado',
            hAxis: {
              title: 'Ciudades',
              viewWindow: {
                min: [7, 30, 0],
                max: [17, 30, 0]
              }
            },
            vAxis: {
              title: 'Número de Arrendamientos'
            }
          };
    
	var chart = new google.visualization.ColumnChart(document.getElementById('rpt-ciudad-estado'));
	chart.draw(data, options);
}