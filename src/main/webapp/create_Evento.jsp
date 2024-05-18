<%-- 
    Document   : create_Evento
    Created on : 12 abr 2024, 9:45:23
    Author     : macuser
--%>

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

	<title>Login-PlannetPro</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>

<body>
    <%
    // Recupera los productos seleccionados del parámetro enviado desde el formulario
    String productosSeleccionados = request.getParameter("productosSeleccionados");

    // Verifica si hay productos seleccionados
    if (productosSeleccionados != null && !productosSeleccionados.isEmpty()) {
        // Divide la cadena de productos seleccionados en un array
        String[] productos = productosSeleccionados.split(",");

        // Itera sobre el array de productos y realiza las acciones necesarias con cada producto
        out.println("<h1>Productos Seleccionados:</h1>");
        out.println("<ul>");
        for (String producto : productos) {
            out.println("<li>" + producto + "</li>");
            // Aquí puedes realizar cualquier acción adicional con cada producto,
            // como guardar en la base de datos, procesar la información, etc.
        }
        out.println("</ul>");
    } else {
        out.println("<h1>No se han seleccionado productos.</h1>");
    }
%>
   
    <% System.out.println(productosSeleccionados); %>
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="text-center my-5">
						<a href="index.jsp"><img src="assets/img/apple-icon.png" alt="logo" width="100"></a>
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
                                                    <center><h1 class="fs-4 card-title fw-bold mb-4">Crea tu evento</h1></center>
							<form action="createEventoServ" method="post" class="needs-validation">
                                                            <input type="hidden" name="seleccion" value="<%= request.getParameter("seleccion")%>">
                                                                 <input type="hidden" name="productosSeleccionados" value="<%= request.getParameter("productosSeleccionados")%>">
                                                                
								<div class="mb-3">
									<label class="mb-2 text-muted" for="NombreEvento">Nombre del evento</label>
									<input id="email" type="text" class="form-control" name="nomEvento" >
									<div class="invalid-feedback">
										Email is invalid
									</div>
								</div>
                                                            <div class="mb-3">
									<label class="mb-2 text-muted" for="LugarEvento">Lugar del evento</label>
									<input id="email" type="text" class="form-control" name="lugEvento" >
									<div class="invalid-feedback">
										
									</div>
								</div>
<div class="mb-3">
									<label class="mb-2 text-muted" for="FechaEvento">Fecha del evento</label>
									<input id="fechaEvento" type="date" class="form-control" name="fechEvento">
									<div class="invalid-feedback">
										
									</div>
								</div>
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="metodoPago" name="metodoPago">Método de Pago</label>	
									</div>
                                                                    <select id="metodoPago" name="metodoPago">
                                                                        <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
                                                                          <option value="Transferencia">Transferencia Bancaria</option>
                                                                            <option value="Pago en Efectivo">Pago en Efectivo</option>
                                                                            
    </select>
								    <div class="invalid-feedback">
								    	
							    	</div>
                                                                    
								</div>

								<div class="d-flex align-items-center">
									<div class="form-check">
									
									</div>
                                                                          
									<button type="submit" class="btn btn-primary ms-auto">
										Guardar y Enviar
									</button>
								</div>
							</form>
                                                    <script>
// Obtener la referencia al campo de entrada
var fechaInput = document.getElementById('fechaEvento');

// Obtener la fecha actual
var fechaActual = new Date().toISOString().split('T')[0];

// Establecer la fecha mínima permitida en el campo de entrada
fechaInput.setAttribute('min', fechaActual);
</script>
						</div>
						<div class="card-footer py-3 border-0">
<!--							<div class="text-center">
								¿No tienes una cuenta?<a href="register.html" class="text-dark">Crear</a>
							</div>-->
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