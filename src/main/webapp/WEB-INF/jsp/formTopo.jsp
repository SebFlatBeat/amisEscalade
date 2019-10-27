<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 09/10/2019
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Enregistrer un Topo</title>

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
                <h1>Enregistrement d'un topo</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}index">Home</a></li>
                <li><a href="<c:url value="/espacePerso"/>">Mon espace perso</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Section: FormTopo -->
<section id="search" class="home-section">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>Enregistrez votre nouveau Topo</h2>
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
                <form id="contact-form" action="/saveFormTopo" method="post" role="form" class="contactForm">
                    <div class="row">
                        <div class="dropdown">
                            <button class="btn btn-warning dropdown-toggle" type="button" id="spotList" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Choissisez le spot à affilier à votre Topo
                            </button>
                            <div class="dropdown-menu" aria-labelledby="spotList">
                                <c:forEach items="${spotList}" var="spot">
                                    <a class="dropdown-item">${spot.spotName}<input type="hidden" id="spotId" name="spotId" value="${spot.spotName}"></a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="topoName">
                                   Le nom du Topo</label>
                                <input type="text" name="topoName" class="form-control" id="topoName" placeholder="Entrez le nom du topo" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="topoCountry">
                                    Pays</label>
                                <input type="text" name="topoCountry" class="form-control" id="topoCountry" placeholder="Entrez le pays" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="topoDepartement">
                                    Département</label>
                                <input type="text" name="topoDepartement" class="form-control" id="topoDepartement" placeholder="Entrez le département" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="topoCity">
                                    Ville</label>
                                <input type="text" name="topoCity" class="form-control" id="topoCity" placeholder="Entrez la ville" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <div class="validation"></div>
                            </div>
                        </div>

                            <div class="col-md-12">
                            <div class="form-group">
                                <label for="topoDescription">
                                    Description</label>
                                <textarea class="form-control" name="topoDescription" id="topoDescription" placeholder="Entrez votre description"></textarea>
                                <div class="validation"></div>
                            </div>
                        </div>
                            </div>
                    <div class="col-md-12 boxed-grey">
                        <fieldset class="form-group">
                            <div class="row">
                                <label class="col-form-label col-md-2 pt-0">Vous souhaitez rendre le topo</label>
                                <div class="col-md-2">
                                    <div class="form-check">
                                        <label class="form-check-label" for="gridRadios1">
                                            Disponible
                                            <input class="form-check-input center-block" type="radio" name="available" id="gridRadios1" value="true" checked>
                                        </label>
                                    </div>
                                    <div class="form-check">

                                        <label class="form-check-label" for="gridRadios2">
                                            Indisponible
                                            <input class="form-check-input center-block" type="radio" name="available" id="gridRadios2" value="false">
                                        </label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class='col-md-2'>
                                        <div class="form-group">
                                            <label class="form-check-label">Date de parution</label>
                                            <div class='input-group date' >
                                                <input type="date" class="form-control" id="release" name="release" />
                                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
                                Valider</button>
                        </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- /Section: FormTopo -->

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



</body>

</html>

