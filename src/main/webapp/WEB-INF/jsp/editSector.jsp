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

    <title>Editer un Secteur</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="img/mountain_favicon.png" />

    <!-- Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="/css/style.css" rel="stylesheet"/>
    <link href="/color/default.css" rel="stylesheet"/>

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
                <h1>Edition d'un secteur</h1>
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

<!-- Section: EditSpot -->
<section id="search" class="home-section">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading text-center">
                            <h2>Modifiez un Secteur</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 boxed-grey">
            <form id="contact-form" action="/spoot/${spotId}/sector/${sectorId}/updateFormSpot" method="post" role="form" class="contactForm center-block" name="formSpot">
                <div class="col-lg-push-2 col-md-3 form-group">
                    <div class="form-group">
                        <label for="spotName">Nom actuel du spot :</label>
                        <h4>${spot.spotName}</h4>
                    </div>
                </div>
                <div class="col-lg-push-1 col-md-6">
                    <div class="form-group">
                        <label for="spotName">Modifiez le nom du Spot</label>
                        <input id="spotName" name="spotName" class="form-control" type="text" value="${spot.spotName}"/>
                    </div>
                </div>


                <div class="row col-md-12 form-group">
                    <div class="col-lg-push-2 col-md-3 form-group">
                        <div class="form-group">
                            <label for="spotName">Lieu actuel du spot :</label>
                            <h4>${spot.cartography.communeCartography} (${spot.cartography.codePostalCartography})</h4>
                        </div>
                    </div>
                    <div class="col-lg-push-1 col-md-6">
                        <label for="spotNameId">Modifiez le lieu</label>
                        <select  id="spotNameId" name="spotNameId" data-placeholder="Modifiez le lieu" class="chosen-select">
                            <option></option>
                            <c:forEach var="selectCity" items="${cartographyListCity}">
                                <option value="${selectCity.id}">${selectCity.communeCartography} (${selectCity.codePostalCartography})</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="row col-md-12 form-group">
                        <fieldset class="col-lg-push-3 col-md-6 form-group">
                            <label class="col-form-label col-md-8 pt-0">Tagger le spot comme étant un spot Offciel "les amis de l'escalade" ?</label>
                            <div class="col-md-4">
                                <div class="form-check">
                                    <label class="form-check-label" for="gridRadios1">
                                        Oui
                                        <input class="form-check-input center-block" type="radio" name="tag" id="gridRadios1" value="true" checked/>
                                    </label>
                                </div>
                                <div class="form-check">

                                    <label class="form-check-label" for="gridRadios2">
                                        Non
                                        <input class="form-check-input center-block" type="radio" name="tag" id="gridRadios2" value="false"/>
                                    </label>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                </div>
        <div class="col-md-12">
            <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
                Modifier</button>
        </div>
        </form>
    </div>
    </div>
</section>
<!-- /Section: EditSpot -->

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

