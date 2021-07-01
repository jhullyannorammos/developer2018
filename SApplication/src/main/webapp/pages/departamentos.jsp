

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--JQuery-->
<link rel="stylesheet"	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap core CSS -->
<link href="../sb-admin/css/bootstrap.css" rel="stylesheet">
<link href="../sb-admin/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="../sb-admin/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

<!-- DataTable.net -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

</head>

<script type="text/javascript">
$(document).ready(function(){

	$('#datatable-departaments').DataTable( {
        "lengthMenu": [[4], [4]]
    });
	
	/*$('#table-departaments').DataTable({
		"lengthMenu" : [[4], [4]],
		"processing": true,
		"serverSide": true,
		columns: [
		      { title: "Localidade" },
		      { title: "Hierarquia" },
		      { title: "Departamento" },
		      { title: "Sigla" },
		      { title: "quantidade" },
		      { title: "codigo" }
		],
        "ajax": {
            "url": "Departamentos?actionServlet=400",
            'method' : 'GET',
            'contentType': "application/json; charset=utf-8",
        }
	  });*/
	
	
		$("#save-dep").click(function() {
			var sgl = $('#sgl').val();
			var dpt = $('#dpt').val();
			var hrq = $('#hrq').val();
			var cdd = $('#cdd').val();
			var fdc = $('#fdc').val();
			$.ajax({
				method : 'POST',
				url : 'Departamentos?actionServlet=100',
				data : {
			    	'dpt' : dpt,
					'sgl' : sgl,
					'hrq' : hrq,
					'cdd' : cdd
				}, error : function(data) {
					$("#dialog").addClass('alert alert-dismissable alert-warning');
					$("#dialog").html('<button type="button" class="close" data-dismiss="alert">&times;</button>');
					$("#dialog").dialog("Erro :" + data);
				},
				success : function(data) {
					$("#dialog").addClass('alert alert-dismissable alert-success');
				    $("#dialog").text("Mensagem :"	+ data	+ " adicionado");
				}
		    });
			$('#dpt').val("");
			$('#sgl').val("");
	  });


});

  /*
  function findAllDepartamentos() {
	 var datatable = '';
	 $.ajax({
	  method : 'GET',
  	  url : "Departamentos?actionServlet=400",
  	  contentType: "application/json; charset=utf-8",
  	  error : function(data) {
			$("#dialog").addClass('alert alert-dismissable alert-warning');
			$("#dialog").html('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$("#dialog").dialog("Erro :" + data);
	  },
	  success : function(data) {
		  if(data.length > 0){
			  var datatable = '';
			  data.forEach(function(element, index) {
				  datatable += "<tr>";
				  datatable += "<td>" + element.localidade + "</td>";
				  datatable += "<td>" + element.hierarquia + "</td>";
				  datatable += "<td>" + element.departamento + "</td>";
				  datatable += "<td>" + element.sigla + "</td>";
				  datatable += '<td><span class="badge">' + element.quantidade + " colaboradores</span></td>";
				  datatable += "<td>" + element.codigo + "</td>";
				  datatable += "</tr>";
			  });
			  $('#datatable-departaments tbody').append(datatable);
		  }   
		  
	   }
	});
  }
*/

  function findAllCidades(){
     $.ajax({
    	method : 'GET',
    	url : "Cidades?actionServlet=400",
    	contentType: "application/json; charset=utf-8",
    	dataType: "JSON",
    	error : function(data) {
			$("#dialog").addClass('alert alert-dismissable alert-warning');
			$("#dialog").html('<button type="button" class="close" data-dismiss="alert">&times;</button>');
			$("#dialog").dialog("Erro :" + data);
		},
		success : function(data) {
			var option = "<option>Selecione a localidade </option>";
			if (data.length > 0) {	
				data.forEach(function(element, index) {
					option += '<option value="'; 
					option += element.cidade; 
					option += '-'; 
					option += element.sigla; 
					option += '">';
					option += element.cidade; 
					option += '-';
					option += element.sigla; 
					option += '</option>';
				    $("#cdd").html(option).show();
				});
			}
			findAllDepartamentos();
		}
    });
  }


  
</script>

<body onload="findAllCidades()">
	<div id="page-wrapper">
		<div class="row">

			<div id="wrapper">

				<h2>
					<small></small>
				</h2>
				<ol class="breadcrumb">
					<li><a href=""><i class="fa fa-user"></i> Pesquisa</a></li>
					<li class="active"><i class="fa fa-edit"></i> Departamentos</li>
				</ol>

				<div id="dialog">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
				</div>

				<div class="col-lg-12">
					<form>
						<table class="table table-hover tablesorter">
							<thead>
								<tr>
									<th>Hierarquia</th>
									<th>Departamento</th>
									<th>Sigla</th>
									<th>Cidade</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<th><select id="hrq" class="form-control">
										<option>Superintendência</option>
										<option>Gerência</option>
										<option>Coordenação</option>
								</select></th>
								<th><input id="dpt" class="form-control" name="dpt" /></th>
								<th><input id="sgl" class="form-control" name="sgl" /></th>
								<th><select id="cdd" class="form-control">

								</select></th>
								<th>
									<button id="save-dep" type="button" class="btn btn-success">Cadastrar</button>
								</th>
							</tbody>
						</table>
					</form>
				

                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br /> 
                    <br /> 
                    <br /> 
                    <br /> 
                    <br />
                    
                    <table id="datatable-departaments" class="display">
					<thead>
					    <tr>
					       <th>Cidade</th>
					       <th>Hierarquia</th>
					       <th>Departamento</th>
					       <th>Sigla</th>
					       <th>Colaboradores</th>
					       <th>Atualização</th>
					    </tr>
					</thead>
					<tbody>
				    
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><span class="badge"></span></td>
								<td>
									<button onclick="" title="Editar" type="button" class="btn btn-default">
										<i class="fa fa-edit"></i>
									</button>
								</td>
							</tr>
						
						</tbody>
				</table>

				</div>
			</div>
		</div>
	</div>
	
</body>




</html>