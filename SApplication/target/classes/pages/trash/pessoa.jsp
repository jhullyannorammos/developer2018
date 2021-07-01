<!DOCTYPE html>
<html>
<head>
<!--JQuery-->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
<link href="../sb-admin/css/bootstrap.css" rel="stylesheet">
<!-- Add custom CSS here -->
<link href="../sb-admin/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="../sb-admin/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>


<script type="text/javascript" >

$(document).ready(function(){
	
	$('#save-person').click(function(){

	    var prn = $('#prn').val();
	    var sgn = $('#sgn').val();
	    var sbn = $('#sbn').val();
	    var unm = $('#unm').val();
	    var eml = $('#eml').val();
	    var dtn = $('#dtn').val();
	    var cnh = $('#cnh').val();
	    var rgg = $('#rgg').val();
	    var cpf = $('#cpf').val();
	    var formulary = $('#formulary').serialize();
	    
	    $.ajax({
	    	method : 'POST',
			url : 'Pessoas?actionServlet=100',
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
			success : function(data) {
				$("#dialog").addClass('alert alert-success alert-dismissable');
				$("#dialog").text("Mensagem: " + data + " cadastrado com sucesso.");

				$('#prn').val("");
				$('#sgn').val("");
				$('#sbn').val("");
				$('#umn').val("");
				$('#eml').val("");
				$('#dtn').val("");
				$('#cpf').val("");
				$('#cnh').val("");
				$('#rgg').val("");
				
			},
			error : function(data) {
				$("#dialog").addClass('alert alert-warning alert-dismissable');
				$("#dialog").dialog("Erro :" + data);
			}
	    });

	});
	
	$("#dtn").mask("99/99/9999");
	$("#fone").mask("(99)99999-9999");
	$("#cpf").mask("000.000.000-00");
	$("#rgg").mask("00.000.000-00");
	$("#cnh").mask("00000000000");
	$("#cnpj").mask("00.000.000/0000-00");
});
</script>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div id="wrapper">
				<h1>
					<small></small>
				</h1>
				<ol class="breadcrumb">
					<li><a href=""><i class="fa fa-user"></i> Cadastro</a></li>
					<li class="active"><i class="fa fa-edit"></i> Pessoal</li>
				</ol>
				<form id="formulary">
					<div class="col-lg-10">
						<button id="save-person" type="button" class="btn btn-success">Cadastrar</button>
						<br /><br />
						<div id="dialog"></div>
                        <br />
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped tablesorter">
								<thead>
									<tr>
										<th>Primeiro Nome <i class="fa fa-sort"></i></th>
										<th>Segundo Nome <i class="fa fa-sort"></i></th>
										<th>Sobrenome <i class="fa fa-sort"></i></th>
										<th>Ultimo Nome <i class="fa fa-sort"></i></th>
									</tr>
								</thead>
								<tbody>
									<tr class="active">
										<td><input id="prn" class="form-control" name="prn" /></td>
										<td><input id="sgn" class="form-control" name="sgn" /></td>
										<td><input id="sbn" class="form-control" name="sbn" /></td>
										<td><input id="unm" class="form-control" name="unm" /></td>
									</tr>
								</tbody>
							</table>
							<table class="table table-bordered table-hover table-striped tablesorter">
								<thead>
									<tr>
										<th>Data de Nascimento <i class="fa fa-sort"></i></th>
										<th>RG <i class="fa fa-sort"></i></th>
										<th>CPF <i class="fa fa-sort"></i></th>
										<th>CNH <i class="fa fa-sort"></i></th>
									</tr>
								</thead>
								<tbody>
									<tr class="active">
										<td><input id="dtn" class="form-control" name="dtn" /></td>
										<td><input id="rgg" class="form-control" name="rgg" /></td>
										<td><input id="cpf" class="form-control" name="cpf" /></td>
										<td><input id="cnh" class="form-control" name="cnh" /></td>
									</tr>
								</tbody>
							</table>
							<table class="table table-bordered table-hover table-striped tablesorter">
								<thead>
									<tr>
										<th>E-Mail <i class="fa fa-sort"></i></th>
									</tr>
								</thead>
								<tbody>
									<tr class="active">
										<td><div class="form-group input-group"><span class="input-group-addon">@</span> <input type="text" name="eml" id="eml" class="form-control" maxlength="30" placeholder="Username@domain.com">
									</div></td>
									</tr>
								</tbody>
							</table>		
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
