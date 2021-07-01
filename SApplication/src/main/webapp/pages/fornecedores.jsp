<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
<link href="../sb-admin/css/bootstrap.css" rel="stylesheet">
<!-- Add custom CSS here -->
<link href="../sb-admin/css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="../sb-admin/font-awesome/css/font-awesome.min.css">

<!-- DataTable.net -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table-fornecedor').DataTable( {
	        "lengthMenu": [[4], [4]]
	    });
	});
</script>
</head>

<body>
	<div id="page-wrapper">
		<div class="row">

			<div id="wrapper">

				<h2>
					<small></small>
				</h2>
				<ol class="breadcrumb">
					<li><a href=""><i class="fa fa-user"></i> Pesquisa</a></li>
					<li class="active"><i class="fa fa-edit"></i> Fornecedores</li>
				</ol>
				
				<form>
					<div class="col-lg-12">
						<div class="bs-example">
							<ul class="nav nav-tabs" style="margin-bottom: 15px;">
								<li class="active"><a href="#home" data-toggle="tab">Home</a></li>
								<li><a href="#endereco" data-toggle="tab">Endereco</a></li>
								<li><a href="#telefone" data-toggle="tab">Telefone</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="home">
									<table class="table table-hover tablesorter">
										<thead>
											<tr>
												<th>Fornecedor </th>
												<th>Razao social </th>
												<th>CNPJ </th>
												<th>Abrangencia </th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th><input id="fbt" class="form-control" name="fbt" size="20" /></th>
												<th><input id="rzs" class="form-control" name="rzs" /></th>
												<th><input id="cnpj" class="form-control" name="cnpj" maxlength="8" /></th>
												<th><select id="abg" class="form-control" name="abg" />
														<option>Selecione uma abrangencia:</option>
														<option value="1">INTERNACIONAL</option>
														<option value="2">NACIONAL</option>
												</select></th>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="endereco">
									<table class="table table-hover tablesorter">
										<thead>
											<tr>
												<th>Endereco </th>
												<th>CEP </th>
												<th>Logradouro </th>
												<th>Rua </th>
												<th>Numero </th>
												<th>Lote </th>
												<th>Quadra </th>
												<th>Complemento </th>
												<th>Estado </th>
												<th>Cidade </th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th><select id="tipo" class="form-control" name="tipo">
														<option>Selecione um tipo:</option>
														<option value="1">RESIDENCIAL</option>
														<option value="2">COMERCIAL</option>
												</select></th>
												<th><input id="cep" class="form-control" name="cep" maxlength="8" /></th>
												<th><input id="lgd" class="form-control" name="lgd" /></th>
												<th><input id="rua" class="form-control" name="rua" /></th>
												<th><input id="nmr" class="form-control" name="nmr" size="20" /></th>
												<th><input id="lte" class="form-control" name="lte" /></th>
												<th><input id="qdr" class="form-control" name="qdr" /></th>
												<th><input id="cpm" class="form-control" name="cpm" /></th>
												
												<th><select id="uf" class="form-control" name="uf">
														<option>Selecione um estado:</option>
														<option value="10">MARANHAO</option>
														<option value="11">MATO GROSSO</option>
														<option value="12">MATO GROSSO DO SUL</option>
														<option value="13">MINAS GERAIS</option>
														<option value="14">PARA</option>
														<option value="15">PARAIBA</option>
														<option value="16">PARANA</option>
														<option value="17">PERNAMBUCO</option>
														<option value="18">PIAUI</option>
														<option value="19">RIO DE JANEIRO</option>
														<option value="20">RIO GRANDE DO NORTE</option>
														<option value="21">RIO GRANDE DO SUL</option>
														<option value="22">RONDONIA</option>
														<option value="23">RORAIMA</option>
														<option value="24">SANTA CATARINA</option>
														<option value="25">SAO PAULO</option>
														<option value="26">SERGIPE</option>
														<option value="27">TOCANTINS</option>
												</select></th>
												<th><select id="uf" class="form-control" name="uf">
														<option>Selecione uma cidade:</option>
												</select></th>
												<tr>
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade" id="telefone">
									<table class="table table-hover tablesorter">
										<thead>
											<tr>
												<th>Telefone </th>
												<th>DDD </th>
												<th>Fone </th>
												<th> </th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th><select id="tipo" class="form-control" name="tipo">
														<option>Selecione um fone:</option>
														<option value="1">RESIDENCIAL</option>
														<option value="2">COMERCIAL</option>
												</select></th>
												<th><select id="tipo" class="form-control" name="tipo">
														<option>Selecione um DDD:</option>
														<option value="2">11</option>
														<option value="1">61</option>
														<option value="2">62</option>
														<option value="2">77</option>
												</select></th>
												<th><input id="fone" class="form-control" name="ddd" maxlength="9" /></th>
												<th><button id="save-item" type="button" class="btn btn-success">Cadastrar</button></th>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
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
                    <br /> 
                    <br /> 
                    <br />
                    <br /> 
                    <br /> 
                    <br />

				<table id="table-fornecedor" class="display">
					<thead>
						<tr>
							<th>Fornecedor</th>
							<th>Abrangência</th>
							<th>Prototipos</th>
							<th>Telefone</th>
							<th>CEP</th>
							<th>Local</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td></td>
								<td></td>
								<td> <span class="badge">  modelo(s)</span></td>
								<td></td>
								<td></td>
								<td></td>
								<td>
									<button title="Editar" type="button" class="btn btn-default">
										<i class="fa fa-edit"></i>
									</button>
									<button title="Remover" type="button" class="btn btn-default">
										<i class="fa fa-trash-o"></i>
									</button>
								</td>
							</tr>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>

</html>