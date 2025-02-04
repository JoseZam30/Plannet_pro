<%-- 
    Document   : inicionSesion
    Created on : 22 abr 2024, 1:07:55
    Author     : macuser
--%>

<%@page import="com.mycompany.Controller.*"%>
<%@page import="com.mycompany.Controller.UsuarioPlannetPro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="author" content="Muhamad Nauval Azhar">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta name="description" content="This is a login page template based on Bootstrap 5">
        
    <link rel="apple-touch-icon" href="assets/img/apple-icon-removebg-preview.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/apple-icon.ico">
    <link rel="icon" href="assets/img/apple-icon.ico" type="image/x-icon">
    
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<title>Login-PlannetPro</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>

<body>
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="text-center my-5">
						<a href="index.html"><img src="assets/img/apple-icon.png" alt="logo" width="100"></a>
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
                                                    <center><h1 class="fs-4 card-title fw-bold mb-4">Inicia Sesion</h1></center>
                                                    <%-- Verificar si hay un mensaje de error y mostrarlo --%>
                                        <% if (request.getAttribute("errorMensaje") != null) { %>
                                     <div style="color: red;">
                                 <strong>Error:</strong> <%= request.getAttribute("errorMensaje") %>
                                        </div>
                                                    <% } %>
							<form action="UsuarioPlannetPro" method="post" class="needs-validation" novalidate="" autocomplete="off">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">Direccion de Correo Electronico</label>
									<input id="email" type="email" class="form-control" name="email" value="" required autofocus>
									<div class="invalid-feedback">
										Email is invalid
									</div>
								</div>

								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="password">Contraseña</label>
										<a href="forgot.html" class="float-end">
											¿Olvidaste tu contraseña?
										</a>
									</div>
									<input id="password" type="password" class="form-control" name="password" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								<div class="d-flex align-items-center">
									<div class="form-check">
									
									</div>
									<button type="submit" class="btn btn-primary ms-auto" name="accion" value="ingresar">
										Login
									</button>
								</div>
                                    <div id="alertNO" class="alert alert-danger" role="alert" style="display: none;">Complete los datos</div>

							</form>
                                                    
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								¿No tienes una cuenta?<a href="register.html" class="text-dark">Crear</a>
							</div>
						</div>
					</div>
					<div class="text-center mt-5 text-muted">
					 
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/login.js"></script>
</body>
</html>