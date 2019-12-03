<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 09/10/2019
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spot en détail</title>

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
            <a class="navbar-brand" href="<c:url value="/index"/>">
                <h1>Détail d'un spot</h1>
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

<!-- Section: DetailSpot -->
<section id="search" class="home-section">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading text-center">
                            <h2>${spotDetails.spotName}</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="service-box team boxed-grey">
                <div class="service-desc">
                    <table class="table table-sm">
                        <thead>
                        <tr class="bg-primary">
                            <th class="text-center" scope="col"> Nom du secteur</th>
                            <th class="text-center" scope="col">Coordonées géographique</th>
                            <th class="text-center" scope="col">Accès</th>
                            <th class="text-center" scope="col">Edition</th>
                            <th class="text-center" scope="col">Supression</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sectorList}" var="sector">
                            <tr>
                                <td class="text-center" scope="row"><a href="<c:url value="/spot/${spotId}/sector/${sector.id}/sectorDetails"></c:url>"> ${sector.sectorName}</a></td>
                                <td class="text-center" scope="row">${sector.location}</td>
                                <td class="text-center" scope="row">${sector.access}</td>
                                <td class="text-center" scope="row">
                                    <a type="button" class="btn btn-warning btn-xs" href="<c:url value="/spot/${spotId}/sector/${sector.id}/editSector"></c:url> ">Editer Secteur</a>
                                    <a type="button" class="btn btn-default btn-xs" href="<c:url value="/sector/${sector.id}/roadForm"></c:url> ">Ajouter Voie</a>
                                </td>
                                <td class="text-center" scope="row">
                                    <a type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#confirmDelete${sector.id}">Suprimmer Secteur</a>
                                    <!-- Modal -->
                                    <div class="modal fade" id="confirmDelete${sector.id}" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteTitle" aria-hidden="true" data-backdrop="false">
                                        <div class="modal-dialog fa-align-center" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLongTitle">Attention</h5>
                                                </div>
                                                <div class="modal-body">
                                                    Etes-vous sûr de vouloir supprimer le secteur ${sector.sectorName} ?
                                                </div>
                                                <div class="modal-footer">
                                                    <form action="/sector/${sector.id}/deleteSector" method="post">
                                                        <button type="submit" name="sectorId" id="sectorId" class="btn btn-danger">Supprimer </button>                                           </form>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Retour</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <a type="button" class="btn btn-info pull-right" href="/espacePerso#spots">Retour</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-12">
        <div class="form-group">
            <form action="/spot/${spotId}/saveCommentSpot" method="post" class="col-lg-12">
                <label for="texteComment">Un commentaire sur le spot ${spotDetails.spotName} ?</label>
                <textarea class="form-control" name="texteComment" id="texteComment" placeholder="Entrez votre commentaire"></textarea>
                <input type="hidden" name="spotId" id="spotID" value="${spotDetails.id}"/>
                <button type="submit" class="btn btn-success pull-right" id="btnContactUs">
                    Envoyer</button>
            </form>
        </div>
    </div>
</section>
<!-- /Section:  DetailSpot -->

<!-- Section: DetailSpot -->
<section id="comments" class="home-section">
    <div class="heading-about">
        <div class="container">
            <div class="row col-lg-12">
                <h4>Les Commentaires</h4>
                <c:forEach items="${commentSpots}" var="comment">

                    <div class="boxed-grey col-lg-12 container-fluid table-bordered">
                        <p>par ${comment.climbUser.username} le <fmt:formatDate value="${comment.date}" type="both"></fmt:formatDate></p>
                        <comment>${comment.texteComment}</comment>
                        <a type="button" class=" btn btn-warning pull-right btn-xs " data-toggle="modal" data-target="#confirmUpdate${comment.id}">Modifier</a>
                        <!-- Modal -->
                        <div class="modal fade" id="confirmUpdate${comment.id}" tabindex="-1" role="dialog" aria-labelledby="confirmUpdateTitle" aria-hidden="true" data-backdrop="false">
                            <div class="modal-dialog fa-align-center" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Modifier votre commentaire</h5>
                                    </div>
                                    <form action="/spot/${comment.spot.id}/updateCommentSpot/${comment.id}" method="post">
                                        <div class="modal-body">
                                            <input name="texteComment" id="texteComment" class="form-control" type="text" value="${comment.texteComment}"/>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-success">Modifier</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Retour</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<!-- /Section: DetailSpot -->

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

