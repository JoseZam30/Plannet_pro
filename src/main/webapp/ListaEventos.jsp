<%-- 
    Document   : paqbasic
    Created on : 16 abr 2024, 7:26:03
    Author     : macuser
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.mycompany.Controller.ConsultaEvento"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mycompany.Controller.Usuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.Controller.ConexionBD"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.Controller.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>PlannetPro-Paquetes Info</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon-removebg-preview.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/apple-icon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">

    </head>

    <body>
        <!-- Start Top Nav -->
        <nav class="navbar navbar-expand-lg navbar-light shadow">
            <div class="container d-flex justify-content-between align-items-center">

                <a class="navbar-brand text-success logo h1 align-self-center" href="index.jsp">
                    PlannetPro
                </a>

                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                    <div class="flex-fill">
                        <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Paquetes.jsp">Paquetes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Galeria.jsp">Galeria</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ListaEventos.jsp">Mis Eventos</a>
                            </li> 
                        </ul>
                    </div>
                    <div class="btn-group">
                        <div class="dropdown">
                            <button class="btn btn-danger dropdown-toggle" type="button" id="navbarDropdown" aria-haspopup="true" aria-expanded="false">
                                Cerrar Sesión
                            </button>
                            <% String Correo = (String) request.getSession().getAttribute("Correo");%>






                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#"><%= Correo%></a>
                                <a class="dropdown-item" href="#"></a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="index.html">Cerrar Sesion</a>
                            </div>
                        </div>
                    </div>
                    <script>
                        document.addEventListener("DOMContentLoaded", function () {
                            document.getElementById("navbarDropdown").addEventListener("click", function (event) {
                                if (event.target.classList.contains("dropdown-toggle")) {
                                    var dropdownMenu = event.target.nextElementSibling;
                                    dropdownMenu.classList.toggle("show");
                                }
                            });

                            // Cerrar la lista desplegable cuando se hace clic fuera de ella
                            window.addEventListener("click", function (event) {
                                if (!event.target.matches(".dropdown-toggle")) {
                                    var dropdowns = document.getElementsByClassName("dropdown-menu");
                                    for (var i = 0; i < dropdowns.length; i++) {
                                        var openDropdown = dropdowns[i];
                                        if (openDropdown.classList.contains("show")) {
                                            openDropdown.classList.remove("show");
                                        }
                                    }
                                }
                            });
                        });
                    </script>
                    <div class="navbar align-self-center d-flex">
                        <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                            <div class="input-group">
                                <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                                <div class="input-group-text">
                                    <i class="fa fa-fw fa-search"></i>
                                </div>
                            </div>
                        </div>

                        <a class="nav-icon position-relative text-decoration-none" href="#">

                            <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                        </a>
                    </div>
                </div>

            </div>
        </nav>
        <!-- Close Header -->

        <!-- Modal -->
        <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="w-100 pt-1 mb-5 text-right">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="" method="get" class="modal-content modal-body border-0 p-0">
                    <div class="input-group mb-2">
                        <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                        <button type="submit" class="input-group-text bg-success text-light">
                            <i class="fa fa-fw fa-search text-white"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>


        <!--  Container verde 
        <section class="bg-success py-5">
            <div class="container">
                <div class="row align-items-center py-5">
                    <div class="col-md-8 text-white">
                        <h1>Escoge y Disfruta tu mejor paquete</h1>
                        <p>
                            En plannetPro estamos para servir aqui puedes tener acceso a el evento
                            que este de acuerdo a tus necesidades, cotiza tus necesidades e imformanos.
                        </p>
                    </div>
                    <div class="col-md-4">
                        <img src="assets/img/about-hero.svg" alt="About Hero">
                    </div>
                </div>
            </div>
        </section>
            Container Verde -->
        <!-- Close Banner -->

        <!-- Start Section -->
        <section class="bg-light">
            <div class="container py-5">
                <div class="row text-center py-5">
                    <div class="col-lg-6 m-auto">
                        <a class="navbar-brand text-success logo h1 align-self-center" href="index.html">
                            ¡Organizados Por Ti!
                        </a>

                        <p>
                        <h5>¡Todo el mundo de la Organizacion de eventos en tus manos!</h5>

                    </div>
                </div>

                <div class="table-responsive">
                   
                    <br>
                    <table class="table table-striped table-hover" style="width: 81%; margin-left: 10%;">
                         <thead class="table-light">
                        <tr>
                            <th>Nombre del Evento</th>
                            <th>Lugar del Evento</th>
                            <th>Fecha del Evento</th>
                            <th>Tipo de Paquete</th>
                            <th>Estado del Evento</th>
                            <th>Método de Pago</th>
                        </tr>
                        <% String idString = (String) request.getSession().getAttribute("ID");
                            int idInt = Integer.parseInt(idString);
                            ConsultaEvento dao = new ConsultaEvento();
                            List<Evento> listaEventos = dao.obtenerEventosUsuario(idInt);
                            Iterator<Evento> iter = listaEventos.iterator();
                            Evento evento = null;
                            while (iter.hasNext()) {
                                evento = iter.next();

                        %>

                        <tr>
                            <td><%= evento.getNombreEvento()%></td>
                            <td><%= evento.getLugarEvento()%></td>
                            <td><%= new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(evento.getFechaEvento())%></td>
                            <td><%= evento.getTipoPaquete()%></td>
                            <td><%= evento.getEstadoEvento()%></td>
                            <td><%= evento.getMetodoPago()%></td>
                        </tr>
                        <%
                            }
                        %>
                         </thead>
                    </table>
                </div>                                   


            <!-- Segunda Fila 
                <div class="row">
                    <div class="col-12 col-md-6 mb-4">
                        <p class="h2 text-decoration-none text-dark">Imagen de este lado</p>
                    </div>
                    <div class="col-12 col-md-6 mb-4">
                        <p>Descripción de la imagen. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod Lorem ipsum dolor sit amet. 
                       </p>
                    </div>
                </div>
            -->
  



    <!-- Fin d Paquete bacis-->
    <!-- Paquete Max 
    <div class="col-12 col-md-4 mb-4">
        <div class="card h-100">
            <a href="">
                <img src="./assets/img/3.png" class="card-img-top" alt="...">
            </a>
            <div class="card-body">
                <ul class="list-unstyled d-flex justify-content-between">
                  
               </ul>
                <h1> $00.000</h1>
                <a href="" class="h2 text-decoration-none text-dark">Orquestas</a>
                <p class="card-text">
Es un honor estar aquí esta noche representando a OrquestaX. Somos un grupo de músicos apasionados y dedicados que nos esforzamos por llevar la belleza y la emoción de la música clásica a audiencias de todas las edades y orígenes.                            </p>
                <p class="text-muted">Reviews (48)</p>
            </div>
        </div>
    </div>
    <!-- Fin d Paquete Max -->
    <!-- Paquete Gold 
    <div class="col-12 col-md-4 mb-4">
        <div class="card h-100">
            <a href="">
                <img src="./assets/img/Plannet_packca.png" class="card-img-top" alt="...">
            </a>
            <div class="card-body">
                <ul class="list-unstyled d-flex justify-content-between">
                   
               </ul>
                <h1> $00.000</h1>
               
                <a href="" class="h2 text-decoration-none text-dark">Entretenimiento</a>
                <p class="card-text">
                    un equipo de bailarines apasionados y dedicados que amamos compartir nuestra pasión por el baile con el mundo. 
                </p>
                <p class="text-muted">Reviews (74)</p>
            </div>
        </div>
    </div>
    <!-- Fin d Paquete Gold -->
</div>
</div>
</section>
<!-- End Section -->

<!-- Start Brands -->
<section class="bg-light py-5">
    <div class="container my-4">
        <div class="row text-center py-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Our Brands</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    Lorem ipsum dolor sit amet.
                </p>
            </div>
            <div class="col-lg-9 m-auto tempaltemo-carousel">
                <div class="row d-flex flex-row">
                    <!-- <div class="col-1 align-self-center">
                        <a class="h1" href="#templatemo-slide-brand" role="button" data-bs-slide="prev">
                            <i class="text-light fas fa-chevron-left"></i>
                        </a>-->

                </div>
                <!--End Controls-->

                <!--Carousel Wrapper-->
                <div class="col">
                    <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="templatemo-slide-brand" data-bs-ride="carousel">
                        <!--Slides-->
                        <div class="carousel-inner product-links-wap" role="listbox">

                            <!--First slide <div class="carousel-item active">
                                <div class="row">
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                    </div>
                                </div>
                            </div>-->

                            <!--End First slide-->

                            <!--Second slide-->
                            <div class="carousel-item">
                                <div class="row">
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                    </div>
                                </div>
                            </div>
                            <!--End Second slide-->

                            <!--Third slide <div class="carousel-item">
                                <div class="row">
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                    </div>
                                    <div class="col-3 p-md-5">
                                        <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                    </div>
                                </div>
                            </div>-->

                            <!--End Third slide-->

                        </div>
                        <!--End Slides-->
                    </div>
                </div>
                <!--End Carousel Wrapper-->

                <!--<div class="col-1 align-self-center">
                    <a class="h1" href="#templatemo-slide-brand" role="button" data-bs-slide="next">
                        <i class="text-light fas fa-chevron-right"></i>
                    </a>
                </div>-->

                <!--End Controls-->
            </div>
        </div>
    </div>
</div>
</section>
<!--End Brands-->


<!-- Start Footer -->
<footer class="bg-dark" id="tempaltemo_footer">
    <div class="container">
        <div class="row">

            <div class="col-md-4 pt-5">
                <h2 class="h2 text-success border-bottom pb-3 border-light logo">PlannetPro</h2>
                <ul class="list-unstyled text-light footer-link-list">
                    <li>
                        <i class="fas fa-map-marker-alt fa-fw"></i>

                    </li>
                    <li>
                        <i class="fa fa-phone fa-fw"></i>
                        <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                    </li>
                    <li>
                        <i class="fa fa-envelope fa-fw"></i>
                        <a class="text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                    </li>
                </ul>
            </div>
            <!--  <div class="col-md-4 pt-5">
                 <h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
                 <ul class="list-unstyled text-light footer-link-list">
                     <li><a class="text-decoration-none" href="#">Luxury</a></li>
                     <li><a class="text-decoration-none" href="#">Sport Wear</a></li>
                     <li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
                     <li><a class="text-decoration-none" href="#">Women's Shoes</a></li>
                     <li><a class="text-decoration-none" href="#">Popular Dress</a></li>
                     <li><a class="text-decoration-none" href="#">Gym Accessories</a></li>
                     <li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
                 </ul>
             </div>

             <div class="col-md-4 pt-5">
                 <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                 <ul class="list-unstyled text-light footer-link-list">
                     <li><a class="text-decoration-none" href="#">Home</a></li>
                     <li><a class="text-decoration-none" href="#">About Us</a></li>
                     <li><a class="text-decoration-none" href="#">Shop Locations</a></li>
                     <li><a class="text-decoration-none" href="#">FAQs</a></li>
                     <li><a class="text-decoration-none" href="#">Contact</a></li>
                 </ul>
             </div>

         </div> 
            

         <div class="row text-light mb-4">
             <div class="col-12 mb-3">
                 <div class="w-100 my-3 border-top border-light"></div>
             </div>
             <div class="col-auto me-auto">
                 <ul class="list-inline text-left footer-icons">
                     <li class="list-inline-item border border-light rounded-circle text-center">
                         <a rel="nofollow" class="text-light text-decoration-none" target="_blank" href="http://fb.com/templatemo"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                     </li>
                     <li class="list-inline-item border border-light rounded-circle text-center">
                         <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                     </li>
                     <li class="list-inline-item border border-light rounded-circle text-center">
                         <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                     </li>
                     <li class="list-inline-item border border-light rounded-circle text-center">
                         <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                     </li>
                 </ul>
             </div>
             <div class="col-auto">
                 <label class="sr-only" for="subscribeEmail">Email address</label>
                 <div class="input-group mb-2">
                     <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Email address">
                     <div class="input-group-text btn-success text-light">Subscribe</div>
                 </div>
             </div>
         </div>-->
        </div>

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                            Copyright &copy; 
                            | Designed by <a rel="sponsored" href="https://templatemo.com/page/1" target="_blank">PlannetPro</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

</footer>
<!-- End Footer -->

<!-- Start Script -->
<script src="assets/js/jquery-1.11.0.min.js"></script>
<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/templatemo.js"></script>
<script src="assets/js/custom.js"></script>
<!-- End Script -->
</body>

</html>

