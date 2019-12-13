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
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="/img/mountain_favicon.png" />

    <!-- Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="/css/style.css" rel="stylesheet"/>
    <link href="/color/default.css" rel="stylesheet"/>

    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">

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
                <li><a href="index#search">Chercher</a></li>
                <li><a href="index#spots">Spots</a></li>
                <c:if test="${pageContext.request.userPrincipal == null}">
                    <li><a href="" data-toggle="modal" data-target="#id-popup">Inscription / Connexion</a>
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
                            <li><a href="<c:url value="/espacePerso#spots"/>">Les spots</a></li>
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
                <form id="contact-form" action="/index#spots">
                    <div class="row">
                        <div class="form-group col-md-3">
                            <label for="spotId"> le Spot</label>
                            <select id="spotId" name="spotId" class="chosen-select form-control" data-placeholder="Cherchez par spot" >
                                <option></option>
                                <c:forEach var="findSpot" items="${spot}">
                                    <option value="${findSpot.id}">${findSpot.spotName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="sectorNumber"> le Secteur</label>
                            <select id="sectorNumber" name="sectorNumber" class="chosen-select form-control" data-placeholder="Cherchez par secteur" >
                                <option></option>
                                <c:forEach var="findSector" items="${spotBySectors}">
                                    <option value="${findSector}">${findSector}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="roadNumber"> Nombre de voie</label>
                            <select id="roadNumber" name="roadNumber" class="chosen-select form-control" data-placeholder="Cherchez par le nombre de voie" >
                                <option></option>
                                <c:forEach var="findRoad" items="${roads}">
                                    <option value="${findRoad}">${findRoad}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="scoringId"> La cotation</label>
                            <select id="scoringId" name="scoringId" class="chosen-select form-control" data-placeholder="Cherchez par la cotation" >
                                <option></option>
                                <c:forEach var="findScoring" items="${scorings}">
                                    <option value="${findScoring.road.sector.spot.id}">${findScoring.rating}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="cartographyCityName"> La ville</label>
                            <select id="cartographyCityName" name="cartographyCityName" class="chosen-select form-control" data-placeholder="Cherchez la ville" >
                                <option></option>
                                <c:forEach var="listCity" items="${cartographyListCity}">
                                    <option value="${listCity}">${listCity}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-md-3">
                            <label for="cartographyDepartementName"> Le département</label>
                            <select id="cartographyDepartementName" name="cartographyDepartementName" class="chosen-select form-control" data-placeholder="Cherchez le département" >
                                <option></option>
                                <c:forEach var="listDepartment" items="${cartographyListDepartment}">
                                    <option value="${listDepartment}">${listDepartment}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-md-3">
                            <label for="cartographyRegionName"> La région</label>
                            <select id="cartographyRegionName" name="cartographyRegionName" class="chosen-select form-control" data-placeholder="Cherchez la région" >
                                <option></option>
                                <c:forEach var="listRegion" items="${cartographyListRegion}">
                                    <option value="${listRegion}">${listRegion}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="cartographyCountryName"> Le pays</label>
                            <select id="cartographyCountryName" name="cartographyCountryName" class="chosen-select form-control" data-placeholder="Cherchez la Pays" >
                                <option></option>
                                <c:forEach var="listCountry" items="${cartographyListCountry}">
                                    <option value="${listCountry}">${listCountry}</option>
                                </c:forEach>
                            </select>
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

<!-- Section: spot -->
<section id="spots" class="home-section text-center bg-gray">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>Spots</h2>
                            <i class="fa fa-2x fa-angle-down"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${spot.size()==searchSpot.size()}">
    <c:forEach var="listAllSpot" items="${spot}">
        <div class="col-lg-3">
            <div class="service-box team boxed-grey">
                <div class="service-icon">
                    <img src="img/icons/service-icon-3-ConvertImage.png" alt="" />
                </div>
                <a href="<c:url value="spot/${listAllSpot.id}/spotDetails"/>"><h5>${listAllSpot.spotName}</h5></a>
                <c:forEach var="listAllSpotBySectors" items="${sectorName}">
                    <c:if test="${listAllSpot.id == listAllSpotBySectors.spot.id}">
                        <a href="<c:url value="/spot/${listAllSpotBySectors.spot.id}/sector/${listAllSpotBySectors.id}/sectorDetails"/> "><p> Secteur ${listAllSpotBySectors.sectorName}</p></a></c:if>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
    </c:if>
<c:if test="${spot.size()!=searchSpot.size()}">
    <c:forEach var="listAllSpotSearch" items="${searchSpot}">
        <div class="col-lg-3">
            <div class="service-box team boxed-grey">
                <div class="service-icon">
                    <img src="img/icons/service-icon-3-ConvertImage.png" alt="" />
                </div>
                <a href="<c:url value="spot/${listAllSpotSearch.id}/spotDetails"/>"><h5>${listAllSpotSearch.spotName}</h5></a>
                <c:forEach var="listAllSpotBySectors" items="${spotBySectors}">
                    <c:if test="${listAllSpotSearch.id == listAllSpotBySectors.spot.id}">
                        <a href="<c:url value="/spot/${listAllSpotBySectors.spot.id}/sector/${listAllSpotBySectors.id}/sectorDetails"/> "><p> Secteur ${listAllSpotBySectors.sectorName}</p></a></c:if>
                </c:forEach>
            </div>
        </div>
        </div>
    </c:forEach>
    <div class="col-lg-12">
    <a type="button" class="btn btn-warning pull-right" href="<c:url value="/index#spots"/>">Reset</a>
    </div>
</c:if>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <ul class="company-social">
                    <li class="social-facebook"><a href="https://www.facebook.com" target="_blank"><i class="fa fa-facebook"></i></a></li>
                    <li class="social-twitter"><a href="https://www.twitter.com" target="_blank"><i class="fa fa-twitter"></i></a></li>
                    <li class="social-dribble"><a href="https://www.dribbble.com" target="_blank"><i class="fa fa-dribbble"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- /Section: spot -->

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
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script>
    function toggleOn() {
        $('#available')
    }
    function toggleOff() {
        $('#available')
    }
</script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="chosen/chosen.jquery.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.2.0/anchor.min.js"></script>
<script type="text/javascript">
    $(function() {
        $(".chosen-select").chosen();
    });
</script>
</body>

</html>
