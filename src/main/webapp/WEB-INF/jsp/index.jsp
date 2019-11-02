<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Amis de l'escalade</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="img/mountain_favicon.png" />

    <!-- Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="css/style.css" rel="stylesheet"/>
    <link href="color/default.css" rel="stylesheet"/>

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<!-- Preloader -->
<div id="preloader">
    <div id="load"></div>
</div>

<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}index">
                <h1>Les Amis de l'Escalade</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#intro">Home</a></li>
                <li><a href="#search">Chercher</a></li>
                <li><a href="#entrainement">Training</a></li>
                <li><a href="#news">News</a></li>
                <c:if test="${pageContext.request.userPrincipal == null}">
                <li><a data-toggle="modal" data-target="#id-popup">Inscription / Connexion</a>
                    <div class="modal fade " id="id-popup" tabindex="-1" role="dialog" aria-labelledby="titrePopUp" aria-hidden="true" data-backdrop="false">

                        <div class="modal-dialog ">

                            <div class="modal-content">

                                <!-- le titre de la popup -->
                                <div class="modal-header">
                                    <h4 class="modal-title text-center" id="titrePopUp">Connexion ou Inscription aux Amis de l'Escalade
                                        <!-- lla croix de fermeture de la popup -->
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> </h4>
                                </div>

                                <!-- le contenu HTML de la popup -->
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <div class="row justify-content-md-center">
                                            <div class="col-lg-8 col-lg-offset-2">
                                                <div class="wow bounceInUp" data-wow-delay="0.6s">
                                                    <div class="avatar"><img src="img/works/Logo_ADE.png"  alt="" /></div>
                                                    <div class="card-body border-info">
                                                        <form action="/login" method="post">
                                                            <div class="form-group">
                                                            <div class="col-lg-6 row center-block">
                                                                <label for="username">Username</label>
                                                                <input type="text" name="username" id="username" placeholder="Pseudo"/>
                                                            </div>
                                                            <div class="col-lg-6 row center-block">
                                                                <label for="password">Password</label>
                                                                <input type="password" name="password" id="password" placeholder="Mot de Passe">
                                                            </div>
                                                            </div>
                                                            <div class="form-group">
                                                            <div class="col-lg-12">
                                                                <p></p>
                                                                <input type="submit" class="btn btn-primary pull-right"/>
                                                            </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                        <!-- le pied de page de la popup -->
                                                        <div class="modal-footer row">
                                                            <div class="col-lg-12 row">
                                                                <p></p>
                                                                <p class="text-center">Si tu n'as pas encore de compte chez nous, c'est par ici que ça se passe
                                                                </p>
                                                            </div>
                                                            <div class="col-lg-6 center-block">
                                                            <i class="glyphicon glyphicon-arrow-down"></i>
                                                            </div>
                                                                <div class="col-lg-8 row center-block">
                                                            <a href="<c:url value="/register"/>" type="submit" class="btn btn-warning">Inscription</a>
                                                            </div>
                                                        </div>
                                                </img>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal != null}">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${pageContext.request.userPrincipal.name}<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/espacePerso"/>">Mon espace perso</a></li>
                        <li><a href="<c:url value="/espacePerso#topos"/>">Les topos</a></li>
                        <li><a href="<c:url value="/espacePerso#demandes"/>">Mes demandes</a></li>
                        <li><a href="#">Mes amis</a></li>
                        <li><a href="<c:url value="/logout" />">Déconnexion</a> </li>
                    </ul>
                </li>
                </c:if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Section: intro -->
<section id="intro" class="intro">

    <div class="slogan">
        <h2>BIENVENUE CHEZ <span class="text_color">LES AMIS DE L'ESCALADE</span> </h2>
        <h4>Un site de pasionné, fait par des pasionnés pour les pasionnés</h4>
    </div>
    <div class="page-scroll">
        <a href="#search" class="btn btn-circle">
            <i class="fa fa-angle-double-down animated"></i>
        </a>
    </div>
</section>
<!-- /Section: intro -->

<!-- Section: search -->
<section id="search" class="home-section text-center">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>Cherchez votre spot</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="boxed-grey">

                <div id="sendmessage">Your message has been sent. Thank you!</div>
                <div id="errormessage"></div>
                <form id="contact-form" action="" method="post" role="form" class="contactForm">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="spot">
                                    Spot</label>
                                <input type="text" name="spot" class="form-control" id="spot" placeholder="Le spot" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                            <div class="form-group">
                                <label for="sector">
                                    Secteur</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="sector" id="sector" placeholder="Le secteur" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                    <div class="validation"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="road">
                                    Voie</label>
                                <input type="text" class="form-control" name="road" id="road" placeholder="La voie" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                            <div class="form-group">
                                <label for="scoring">
                                    Cotations</label>
                                <input type="text" class="form-control" name="scoring" id="scoring" placeholder="La cotation" data-rule="minlen:4"  data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
                                Chercher</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- /Section: search -->


<!-- Section: entrainement -->
<section id="entrainement" class="home-section text-center bg-gray">

    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>Training</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-lg-offset-5">
                <hr class="marginbot-50">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="wow fadeInLeft" data-wow-delay="0.2s">
                    <div class="service-box">
                        <div class="service-icon">
                            <img src="img/icons/service-icon-1.png" alt="" />
                        </div>
                        <div class="service-desc">
                            <h5>Print</h5>
                            <p>Vestibulum tincidunt enim in pharetra malesuada. Duis semper magna metus electram accommodare.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="service-box">
                        <div class="service-icon">
                            <img src="img/icons/service-icon-2.png" alt="" />
                        </div>
                        <div class="service-desc">
                            <h5>Web Design</h5>
                            <p>Vestibulum tincidunt enim in pharetra malesuada. Duis semper magna metus electram accommodare.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="service-box">
                        <div class="service-icon">
                            <img src="img/icons/service-icon-3.png" alt="" />
                        </div>
                        <div class="service-desc">
                            <h5>Photography</h5>
                            <p>Vestibulum tincidunt enim in pharetra malesuada. Duis semper magna metus electram accommodare.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="wow fadeInRight" data-wow-delay="0.2s">
                    <div class="service-box">
                        <div class="service-icon">
                            <img src="img/icons/service-icon-4.png" alt="" />
                        </div>
                        <div class="service-desc">
                            <h5>Cloud System</h5>
                            <p>Vestibulum tincidunt enim in pharetra malesuada. Duis semper magna metus electram accommodare.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /Section: entrainement -->




<!-- Section: news -->
<section id="news" class="home-section text-center">
    <div class="heading-contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>News</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">

        <div class="row">
            <div class="col-lg-2 col-lg-offset-5">
                <hr class="marginbot-50">
            </div>
        </div>


            <div class="col-lg-4">
                <div class="widget-contact">
                    <h5>Main Office</h5>

                    <address>
                        <strong>Squas Design, Inc.</strong><br>
                        Tower 795 Folsom Ave, Beautiful Suite 600<br>
                        San Francisco, CA 94107<br>
                        <abbr title="Phone">P:</abbr> (123) 456-7890
                    </address>

                    <address>
                        <strong>Email</strong><br>
                        <a href="mailto:#">email.name@example.com</a>
                    </address>
                    <address>
                        <strong>We're on social networks</strong><br>
                        <ul class="company-social">
                            <li class="social-facebook"><a href="#" target="_blank"><i class="fa fa-facebook"></i></a></li>
                            <li class="social-twitter"><a href="#" target="_blank"><i class="fa fa-twitter"></i></a></li>
                            <li class="social-dribble"><a href="#" target="_blank"><i class="fa fa-dribbble"></i></a></li>
                        </ul>
                    </address>
                </div>
            </div>
        </div>
</section>
<!-- /Section: news -->

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="wow shake" data-wow-delay="0.4s">
                    <div class="page-scroll marginbot-30">
                        <a href="#intro" id="totop" class="btn btn-circle">
                            <i class="fa fa-angle-double-up animated"></i>
                        </a>
                    </div>
                </div>
                <p>&copy;SquadFREE. All rights reserved.</p>
                <div class="credits">
                    <!--
                      All the links in the footer should remain intact.
                      You can delete the links only if you purchased the pro version.
                      Licensing information: https://bootstrapmade.com/license/
                      Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Squadfree
                    -->
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Core JavaScript Files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.min.js"></script>
<script src="js/jquery.scrollTo.js"></script>
<script src="js/wow.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.js"></script>
<script src="contactform/contactform.js"></script>


</body>

</html>
