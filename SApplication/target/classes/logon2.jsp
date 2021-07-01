<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<!--JQuery-->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>



<style>

.logo img {
    position: relative;
    border-bottom-left-radius: 25px;
    margin-top: -50px;
	margin-right: 0px;
	margin-left: auto;
	width: 405px;
	height: 150px;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-height: 600px;
	max-width: 360px;
	margin: auto;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #FFFFFF;
	width: 100%;
	border: #262626;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form input:hover{
    border-bottom: #0088FF;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #0088FF;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	/*border-radius: 25px;*/
	background: #0088FF;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #0088FF;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 0px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	background: #262626; 
	padding: auto;
	margin: auto;
	height: auto;

}
</style>


<script type="text/javascript">
	$(document).ready(function() {

		$('#logon').click(function() {
			windows.alert('Ola mundo');
		});
	});
</script>

<body>
	<div class="form">
	    <div class="logo">
				<img src="src/logo_saneago.png" />
			</div>
		<div class="container">
				<img src="src/avatar_empresario.jpg" /> <br /> <br /> 
				<input id="boxlogin" name="boxlogin" type="text" placeholder="Email" /> 
				<input id="boxpassword" name="boxpassword" type="password" placeholder="Password" />
				<button id="logon" >Entrar</button>
				<p class="message">	Esqueceu sua senha? <a href="logon.jsp?Service=274">Redefina agora</a>
				</p>

		</div>
	</div>


</body>
</html>