<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 11/10/2019
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Esapce Perso</title>

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

    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

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
                <li class="active"><a href="<c:url value="/index"/>">Home</a></li>
                <li><a href="<c:url value="/espacePerso"/>">Mon espace perso</a></li>
                <li><a href="<c:url value="/espacePerso#topos"/>">Les topos</a></li>
                <li><a href="#">Mes spots</a></li>
                <li><a href="#">Mes amis</a></li>
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
                            <li><a href="<c:url value="/index#search"/>">Chercher</a></li>
                            <li><a href="<c:url value="/index#entrainement"/>">Training</a></li>
                            <li><a href="<c:url value="/index#news"/>">News</a></li>
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
<!-- Section: espacePerso -->
<section id="about" class="intro text-center">
    <div class="heading-about">
        <div class="container home-section">
            <div class="row">
                <div class="col-lg-12 center-block">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading text-center">
                            <h2>Mon Espace perso</h2>
                        </div>
                        <div class="col-lg-12 center-block ">
                        <div class="col-md-3">
                            <div class="wow bounceInUp" data-wow-delay="0.2s">
                                <div class="team boxed-grey">
                                    <div class="inner">
                                        <h4>Mon Profil</h4>
                                        <h5 class="h5">${pageContext.request.userPrincipal.name}</h5>
                                        <div class="avatar"><img src="img/icons/user_avatar.png" alt="" class="img-responsive img-circle" /></div>
                                        <button type="button" class="btn btn-outline-dark">Modifier</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                            <div class="col-md-3">
                                <div class="wow fadeInLeft" data-wow-delay="0.2s">
                                    <div class="service-box team boxed-grey">
                                        <div class="service-icon">
                                            <img src="img/icons/service-icon-2.png" alt="" />
                                        </div>
                                        <div class="service-desc">
                                            <h5>Ajouter un nouveau Topo</h5>
                                            <a role="button" class="btn btn-success" href="<c:url value="/formTopo"/>">Ajouter</a>
                                        </div>
                                    </div>
                                </div>
                                    <div class="wow fadeInLeft" data-wow-delay="0.2s">
                                        <div class="service-box team boxed-grey">
                                            <div class="service-icon">
                                                <img src="img/icons/service-icon-2.png" alt="" />
                                            </div>
                                            <div class="service-desc">
                                                <h5>Modifier un Topo</h5>
                                                <button type="button" class="btn btn-warning">Modifier</button>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                                <div class="row">
                                <div class="col-md-6">
                                <div class="wow fadeInLeft" data-wow-delay="0.2s">
                                    <div class="service-box team boxed-grey">
                                        <div class="service-desc">
                                            <h5>Liste de mes Topos</h5>
                                            <table class="table table-sm">
                                                <thead>
                                                <tr class="bg-primary">
                                                    <th class="text-center" scope="col"> Nom du topo</th>
                                                    <th class="text-center" scope="col"> Date de parution</th>
                                                    <th class="text-center" scope="col">Spot</th>
                                                    <th class="text-center" scope="col"> Disponibilté</th>
                                            </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${topoUser}" var="topoClimber">
                                                    <tr>
                                                        <td class="text-center" scope="row">${topoClimber.topoName}</td>
                                                        <td class="text-center" scope="row"><fmt:formatDate value="${topoClimber.release}"></fmt:formatDate></td>
                                                        <td class="text-center" scope="row">${topoClimber.spot.spotName}</td>
                                                        <td class="text-center" scope="row">
                                                            <form action="/topo/${topoClimber.id}/availability" method="post">
                                                                 <input name="availability" id="availability" type="checkbox" data-toggle="toggle" data-onstyle="success" data-on="Disponible" data-offstyle="default" data-off="Indisponible" data-size="mini" ${topoClimber.available ? "checked":""}><button class="btn-xs" type="submit" > OK </button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</section>
<!-- /Section: espacePerso -->

<!-- Section: Les Topos-->
<section id="topos" class="home-section text-center">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>les Topos disponibles</h2>
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
                    <div class="form row">
                        <div class="form-group col-md-3">
                                <label for="spot">
                                    Spot</label>
                                <input type="text" name="spot" class="form-control" id="spot" placeholder="Le spot" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        <div class="form-group col-md-3">
                                <label for="">
                                    Ville</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="topoCity" id="" placeholder="La ville" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                    <div class="validation"></div>
                                </div>
                            </div>
                        <div class="form-group col-md-3">
                                <label for="">
                                    Departement</label>
                                <input type="text" class="form-control" name="topoDepartement"  placeholder="Le departement" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        <div class="form-group col-md-3">
                                <label for="">
                                    Pays</label>
                                <input type="text" class="form-control" name="topoCountry" placeholder="La pays" data-rule="minlen:4"  data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
                                Affiner</button>
                        </div>
                </form>
                <div class="service-box team boxed-grey">
                    <div class="service-desc">
                        <h5>Liste des Topos</h5>
                        <table class="table table-sm">
                            <thead>
                            <tr class="bg-primary">
                                <th class="text-center" scope="col"> Nom du topo</th>
                                <th class="text-center" scope="col"> Date de parution</th>
                                <th class="text-center" scope="col">Spot</th>
                                <th class="text-center" scope="col">Ville</th>
                                <th class="text-center" scope="col">Departement</th>
                                <th class="text-center" scope="col">Pays</th>
                                <th class="text-center" scope="col"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${searchTopos}" var="topos">
                                <tr>
                            <td class="text-center" scope="row">${topos.topoName}</td>
                            <td class="text-center" scope="row">${topos.release}</td>
                            <td class="text-center" scope="row">${topos.spot.spotName}</td>
                            <td class="text-center" scope="row">${topos.topoCity}</td>
                            <td class="text-center" scope="row">${topos.topoDepartement}</td>
                            <td class="text-center" scope="row">${topos.topoCountry}</td>
                            <td class="text-center" scope="row"><button>Demandez la réservation</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /Section: Les Topos -->


<footer>
    <div class="container">
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
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<script>
    function toggleOn() {
        $('#available')
    }
    function toggleOff() {
        $('#available')
    }
</script>


</body>
</html>
