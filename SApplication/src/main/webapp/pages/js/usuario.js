$(document).ready(function () {
	
	$('#table-users').DataTable();
	 
    $('.jqueryDataTable-Pessoa').dataTable( {
        'bProcessing': false,
        'bServerSide': false,
        'sAjaxSource': './PessoaServlet?actionServlet=400',
        'bJQueryUI': true,
        'aoColumns': [
            { 'mData': 'primeiroNome' },
            { 'mData': 'segundoNome' },
            { 'mData': 'sobreNome' },
            { 'mData': 'ultimoNome' }
        ]
    } ); 


    $('#save-user').click(function () {

        var lg = $('#boxlogn').val();
        var pw = $('#boxpswd').val();
        
        $.ajax({
            url: 'Acessos?actionServlet=555',
            data: form,
            type: 'POST',
            beforeSend: function () {
                $('#dialog-save-user').html(iconCarregando);
            },
            error: function (data) {
               $("#dialog-save-user").text('Error: ' + data);
            },
            success: function (data) {
                $("#dialog-save-user").text('Usuario cadastrado com sucesso');
            }
        });
    });


    $('#logon-user').click(function () {

        var logon = $('#boxlogin').val();
        var paswd = $('#boxpassword').val();

        $.ajax({
            type: 'POST',
            url: 'Usuario?actionServlet=100',
            data: {
                lgn: logon,
                psw: paswd
            },
            success: function (responseText) {
            	$('#dialog-logon').html(responseText);
            },
            error: function (responseText) {
            	$('#dialog-logon').html(responseText);
            }
        });
    });

    function update(id) {
        
            var profile = $('#').val();
            var status = $('#').val();
            var email = $('#').val();

            $.ajax({
                type: 'POST',
                url: '',
                data: {
                    idp : id,
                    prf : profile,
                    eml : email,
                    sts : status
                },
                success: function (responseText) {
                    $('#').html(responseText);
                },
                error: function (responseText) {
                    $('#').html(responseText);
                }
            });
        

    }



    $('#teste').click(function () {
 
        
        $.ajax({
                type: 'POST',
                url: 'Acessos?actionServlet=666',
                success: function (responseText) {
                    $('#message').html(responseText);
                },
                error: function (responseText) {
                    $('#message').html(responseText);
                }
            });
        
    });


});