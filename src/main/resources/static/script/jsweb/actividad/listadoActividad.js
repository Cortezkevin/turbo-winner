$(document).on("click", "#btnagregaractividad", function() {
	$("#txtnomactividad").val("");
	$("#txtnomproyecto").val("");
	$("#txtproyid").val("");
	$("#hddidactividad").val("0");
	$("#modalactividad").modal("show");
});

$(document).on("click", ".btnactualizaractividad", function() {
	$("#txtnomactividad").val($(this).attr("data-nomactividad"));
	$("#txtnomproyecto").val($(this).attr("data-nompro"));
	$("#txtproyid").val($(this).attr("data-idpro"));
	$("#hddidactividad").val($(this).attr("data-codactividad"));
	$("#modalactividad").modal("show");
});

$(document).on("click", "#btnregistraractividad", function() {
	if ($("#hddidactividad").val() === "0") {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/Actividad/RegistrarActividad",
			data: JSON.stringify({
				nombre: $("#txtnomactividad").val(),
				nombreProyecto: $("#txtnomproyecto").val(),
				proyecto :{
					id_proyecto: $("#txtproyid").val()
				} 
			}),
			success: function(resultado) {
				if (resultado.respuesta) {
					alert(resultado.mensaje);
					listarActividad();
				} else {
					alert(resultado.mensaje);
				}
			}
		});
	} else {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/Actividad/RegistrarActividad",
			data: JSON.stringify({
				nombre: $("#txtnomactividad").val(),
				nombreProyecto: $("#txtnomproyecto").val(),
				proyecto: $("#txtproyid").val()
				
			}),
			success: function(resultado) {
				if (resultado.respuesta) {
					alert(resultado.mensaje);
					listarActividad();
				} else {
					alert(resultado.mensaje);
				}
			}
		});
	}
	$("#modalcurso").modal("hide");
});
function listarActividad() {
	$.ajax({
		type: "GET",
		url: "/Actividad/listarActividad",
		dataType: "json",
		success: function(resultado) {
			$("#tblactividad > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblactividad > tbody").append("<tr>" +
					"<td>" + value.idActividad + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td>" + value.nombreproyecto +
					"<td>" + value.proyecto.idProyecto + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizaractividad' " +
					" data-codactividad='" + value.idActividad + "'" +
					" data-nomactividad='" + value.nombre + "'" +
					" data-nompro='" + value.nombreProyecto + "'"+
					" data-idpro='" + value.proyecto.idProyecto + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminaractividad' " +
					" data-codactividad='" + value.idActividad + "'" +
					" data-nomactividad='" + value.nombre + "'>Eliminar</button>" +
					"</td></tr>")
			})

		}
	})
}

$(document).on("click", ".btneliminaractividad", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la actividad: " +
		$(this).attr("data-nombre") + "?");
	$("#hddidactividadeliminar").val($(this).attr("data-codactividad"));
	$("#modaleliminaractividad").modal("show");
});

$(document).on("click", "#btneliminaractividad", function() {

});



