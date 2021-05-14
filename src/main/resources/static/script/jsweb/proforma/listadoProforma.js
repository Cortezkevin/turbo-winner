$(document).on("click", "#btnagregarproforma", function() {
	$("#txtnomcliente").val("");
	$("#txtdireccion").val("");
	$("#txtnompro").val("");
	$("#txtimporte").val("");
	$("#hddidproforma").val("0");
	$("#modalproforma").modal("show");
});

$(document).on("click", ".btnactualizaractividad", function() {
	$("#txtnomcliente").val($(this).attr("data-nomcliente"));
	$("#txtdireccion").val($(this).attr("data-direccion"));
	$("#txtnompro").val($(this).attr("data-nompro"));
	$("#txtimporte").val($(this).attr("data-importe"));
	$("#hddidproforma").val($(this).attr("data-codproforma"));
	$("#modalproforma").modal("show");
});

$(document).on("click", "#btnregistrarproforma", function() {
	if ($("#hddidproforma").val() === "0") {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/Proforma/RegistrarProforma",
			data: JSON.stringify({
				cliente: $("#txtnomcliente").val(),
				direccion: $("#txtdireccion").val(),
				nombreProyecto: $("#txtnompro").val(),
				importe: $("#txtimporte").val()
				
			}),
			success: function(resultado) {
				if (resultado.respuesta) {
					alert(resultado.mensaje);
					listarProforma();
				} else {
					alert(resultado.mensaje);
				}
			}
		});
	} else {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/Proforma/RegistrarProforma",
			data: JSON.stringify({
				cliente: $("#txtnomcliente").val(),
				direccion: $("#txtdireccion").val(),
				nombreProyecto: $("#txtnompro").val(),
				importe: $("#txtimporte").val()
			}),
			success: function(resultado) {
				if (resultado.respuesta) {
					alert(resultado.mensaje);
					listarProforma();
				} else {
					alert(resultado.mensaje);
				}
			}
		});
	}
	$("#modalproforma").modal("hide");
});
function listarProforma() {
	$.ajax({
		type: "GET",
		url: "/Proforma/listarProforma",
		dataType: "json",
		success: function(resultado) {
			$("#tblproforma > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblproforma > tbody").append("<tr>" +
					"<td>" + value.idProforma + "</td>" +
					"<td>" + value.cliente + "</td>" +
					"<td>" + value.direccion + "</td>" +
					"<td>" + value.nombreProyecto + "</td>" +
					"<td>" + value.importe + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarproforma' " +
					" data-codproforma='" + value.idProforma + "'" +
					" data-nomcliente='" + value.cliente + "'" +
					" data-direccion='" + value.direccion + "'" +
					" data-nompro='" + value.nombreProyecto + "'"+
					" data-importe='" + value.importe + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarproforma' " +
					" data-codproforma='" + value.idProforma + "'" +
					" data-nomcliente='" + value.cliente + "'>Eliminar</button>" +
					"</td></tr>")
			})

		}
	})
}

$(document).on("click", ".btneliminarproforma", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la proforma: " +
		$(this).attr("data-nombre") + "?");
	$("#hddidproformaeliminar").val($(this).attr("data-codproforma"));
	$("#modaleliminarproforma").modal("show");
});

$(document).on("click", "#btneliminarproforma", function() {

});