<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 10/12/2019
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Enregistrer une Voie</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="/img/mountain_favicon.png" />

    <!-- Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/animate.css" rel="stylesheet" type="text/css" />
    <!-- Squad theme CSS -->
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/color/default.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.css"/>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>

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
            <a class="navbar-brand" href="<c:url value="/index"/>">
                <h1>Les Amis de l'Escalade</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/index"/>">Home</a></li>
                <li><a href="<c:url value="/espacePerso"/>">Mon espace perso</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Section: formRoad -->
<section id="search" class="home-section">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading text-center">
                            <h2>Modifier une voie</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 boxed-grey">
            <form id="contact-form" action="/spot/${spotId}/sector/${sectorId}/road/${roadId}/lenght/${lenghtId}/scoring/${scoringId}/updateRoadForm" method="post" role="form" class="contactForm center-block" name="formSpot">>
                <div class="row col-md-12 form-group">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="roadName">Nom actuel de la voie :</label>
                            <h4>${road.roadName}</h4>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="roadName">Modifiez le nom de la voie</label>
                            <input type="text" id="roadName" name="roadName" class="form-control" value="${road.roadName}"/>
                        </div>
                    </div>
                </div>
                <div class="row col-md-12 form-group">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="distance">Distance actuel de la voie :</label>
                            <h4>${scoring.lenght.distance}</h4>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <label for="distance">Modifiez la distance :</label>
                        <input type="number" id="distance" name="distance" class="form-control" value="${scoring.lenght.distance}"/>
                    </div>
                </div>
                <div class="row col-md-12 form-group">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="height">Hauteur actuel de la voie :</label>
                            <h4>${scoring.lenght.height}</h4>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <label for="height">Modifiez la hauteur :</label>
                        <input type="number" id="height" name="height" class="form-control" value="${scoring.lenght.height}"/>
                    </div>
                </div>
                <div class="row col-lg-12 form-group">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="height">Difficulté actuel de la voie :</label>
                            <h4>${scoring.rating}</h4>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label for="rating">Modifiez la difficulté :</label>
                            <input type="text" id="rating" name="rating" class="form-control" value="${scoring.rating}"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <a type="button" class="btn btn-warning pull-right" href="/spot/${spotId}/sector/${sectorId}/sectorDetails">Retour</a>
                    <button type="submit" class="btn btn-success pull-right" id="btnContactUs">
                        Envoyer
                    </button>

                </div>
            </form>
        </div>
    </div>
</section>
<!-- /Section: formRoad -->

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
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.easing.min.js"></script>
<script src="/js/jquery.scrollTo.js"></script>
<script src="/js/wow.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/js/custom.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="/chosen/chosen.jquery.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.2.0/anchor.min.js"></script>
<script type="text/javascript">
    $(function() {
        $(".chosen-select").chosen();
    });
</script>


</body>

</html>
