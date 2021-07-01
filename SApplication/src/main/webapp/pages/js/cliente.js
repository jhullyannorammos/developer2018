$(document).ready(function(){
	
	$('#save-cliente').click(function(){

	    var prn = $('#prn').val();
	    var sgn = $('#sgn').val();
	    var sbn = $('#sbn').val();
	    var umn = $('#umn').val();
	    var eml = $('#eml').val();
	    var dtn = $('#dtn').val();
	    var cnh = $('#cnh').val();
	    var rgg = $('#rgg').val();
	    var cpf = $('#cpf').val();
	    
	    
	    $.ajax({
			method : 'POST',
			url : 'Clientes?actionServlet=100',
			data : {
				'prn': prn,
				'sgn': sgn,
				'sbn': sbn,
				'umn': umn,
				'dtn': dtn,
				'rgg': rgg,
				'cnh': cnh,
				'cpf': cpf,
				'eml': eml
			},
			error : function(data) {
				$("#dialog").addClass('alert alert-warning alert-dismissable');
				$("#dialog").dialog("Erro falha no cadastro do cliente:" + data);
			},
			success : function(data) {
				
				$.ajax({
					method: 'POST',
					url: 'Usuarios?actionServlet=100',
					data:{'eml': eml},
				    error : function(data) {
					    $("#dialog").addClass('alert alert-warning alert-dismissable');
					    $("#dialog").dialog("Erro falha no cadastro do usuario:" + data);
				    },
				    sucess : function(data){
				    	$("#dialog").addClass('alert alert-success alert-dismissable');
						$("#dialog").text("Mensagem :" + data + " cadastrado com sucesso");
				    }
				});
				
				$('#prn').val("");
				$('#sgn').val("");
				$('#sbn').val("");
				$('#umn').val("");
				$('#eml').val("");
				$('#dtn').val("");
				$('#cpf').val("");
				$('#cnh').val("");
				$('#rgg').val("");
			}
		});
	  });
	
	$('#teste-cliente').click(function(){
		alert('teste-concluido');
	});
	
	$("#dtn").mask("99/99/9999");
	$("#fone").mask("(99)99999-9999");
	$("#cpf").mask("000.000.000-00");
	$("#rgg").mask("00.000.000-00");
	$("#cnh").mask("00000000000");
	$("#cnpj").mask("00.000.000/0000-00");
});


